package com.koscom.zoozooland.web.controller;

import com.koscom.zoozooland.service.CommentService;
import com.koscom.zoozooland.web.dto.CommentListResponseDto;
import com.koscom.zoozooland.web.dto.CommentSaveRequestDto;
import com.koscom.zoozooland.web.dto.StockListResponseDto;
import com.koscom.zoozooland.web.dto.TransactionListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/comment/")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    // 종목별 댓글 수익금 순으로 불러오기
    @GetMapping("/{code}")
    public List<CommentListResponseDto> getStockCommentAll(@PathVariable Long code) {
        return commentService.getStockCommentAll(code);
    }

    // 주주인지 체크
    @GetMapping("/transaction")
    public boolean isZoozoo(@RequestParam Long userId,@RequestParam Long stockCode) {
        return commentService.isZoozoo(userId, stockCode);
    }

    // 댓글 입력
    @PostMapping("/")
    public Long saveComment(@RequestBody CommentSaveRequestDto requestDto) {
        return commentService.saveComment(requestDto);
    }

    // 댓글 매수 매도 내역
    @GetMapping("/transaction/{commentId}")
    public List<TransactionListResponseDto> getTransactionList(@PathVariable Long commentId) {
        return commentService.getTransactionList(commentId);
    }

    // 종목 전체 조회
    @GetMapping("/stock")
    public List<StockListResponseDto> getStockAll() {
        return commentService.getStockAll();
    }
}
