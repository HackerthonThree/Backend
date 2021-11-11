package com.koscom.zoozooland.service;

import com.koscom.zoozooland.domain.account.transaction.TransactionRepository;
import com.koscom.zoozooland.domain.comment.Comment;
import com.koscom.zoozooland.domain.comment.CommentRepository;
import com.koscom.zoozooland.domain.stock.StockRepository;
import com.koscom.zoozooland.domain.user.UserRepository;
import com.koscom.zoozooland.web.dto.CommentListResponseDto;
import com.koscom.zoozooland.web.dto.CommentSaveRequestDto;
import com.koscom.zoozooland.web.dto.StockListResponseDto;
import com.koscom.zoozooland.web.dto.TransactionListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final StockRepository stockRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    // 댓글 입력
    @Transactional
    public Long saveComment(CommentSaveRequestDto requestDto) {
        // System.out.println(requestDto.toString());
        return commentRepository.save(requestDto.toEntity(userRepository.findByNickname(requestDto.getNickname()), stockRepository.findByStockName(requestDto.getStockName()))).getCommentId();
    }

    // 모든 댓글 반환
    @Transactional
    public List<CommentListResponseDto> getStockCommentAll(Long stockCode) {
        return commentRepository.findStockComment(stockCode).stream()
                .map(CommentListResponseDto::new)
                .collect(Collectors.toList());
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
}
