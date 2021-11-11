package com.koscom.zoozooland.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.stock.stockCode = ?1")
    public List<Comment> findStockComment(Long stockCode);
}
