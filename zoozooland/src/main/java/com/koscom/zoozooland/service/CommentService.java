package com.koscom.zoozooland.service;

import com.koscom.zoozooland.domain.account.transaction.Transaction;
import com.koscom.zoozooland.domain.account.transaction.TransactionRepository;
import com.koscom.zoozooland.domain.comment.Comment;
import com.koscom.zoozooland.domain.comment.CommentRepository;
import com.koscom.zoozooland.domain.stock.StockRepository;
import com.koscom.zoozooland.domain.user.User;
import com.koscom.zoozooland.domain.user.UserRepository;
import com.koscom.zoozooland.web.dto.CommentListResponseDto;
import com.koscom.zoozooland.web.dto.CommentSaveRequestDto;
import com.koscom.zoozooland.web.dto.StockListResponseDto;
import com.koscom.zoozooland.web.dto.TransactionListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final StockRepository stockRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    // 해당 종목 매수 매도 내역 확인
    @Transactional
    public boolean isZoozoo(Long userId, Long stockCode) {
        return transactionRepository.existsTransactionByUserAndStock(userRepository.findById(userId).get(), stockRepository.findById(stockCode).get());
    }

    // 댓글 입력
    @Transactional
    public Long saveComment(CommentSaveRequestDto requestDto) {
        // System.out.println(requestDto.toString());
        return commentRepository.save(requestDto.toEntity(userRepository.findByNickname(requestDto.getNickname()), stockRepository.findByStockName(requestDto.getStockName()))).getCommentId();
    }

    // 종목의 모든 댓글 반환
    @Transactional
    public List<CommentListResponseDto> getStockCommentAll(Long stockCode) {
        // dto로 변경
        List<CommentListResponseDto> commentListResponseDtoList = commentRepository.findStockComment(stockCode).stream()
                .map(CommentListResponseDto::new)
                .collect(Collectors.toList());

        // 사용자별 수익금 계산
        for (CommentListResponseDto c : commentListResponseDtoList) {
            c.setEarn(howMuchEarn(userRepository.findByNickname(c.getAuthor()), stockCode));
        }

        // 수익금 높은 순으로 정렬
        Collections.sort(commentListResponseDtoList);

        return commentListResponseDtoList;
    }

    // 댓글 클릭 이벤트
    @Transactional
    public List<TransactionListResponseDto> getTransactionList(Long commentId) {
        Comment comment = commentRepository.findById(commentId).get();
        return transactionRepository.findAllByStockAndUser(comment.getStock().getStockCode(), comment.getUser().getUserId()).stream()
                .map(TransactionListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 종목 종류 전체 반환
    @Transactional
    public List<StockListResponseDto> getStockAll() {
        return stockRepository.findAll().stream()
                .map(StockListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 수익금액 계산
    private Long howMuchEarn(User user, Long stockCode) {
        List<Transaction> privateTransactionList = transactionRepository.findAllByUserAndStock(user, stockRepository.findById(stockCode).get());
        Long result = 0L;
        for(Transaction transaction : privateTransactionList) {
            if (transaction.isTransType()) result -= transaction.getQty() * transaction.getAmount();
            else result += transaction.getQty() * transaction.getAmount();
        }

        return result;
    }
}
