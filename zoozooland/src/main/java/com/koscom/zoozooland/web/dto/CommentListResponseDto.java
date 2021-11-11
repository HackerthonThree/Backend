package com.koscom.zoozooland.web.dto;

import com.koscom.zoozooland.domain.comment.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentListResponseDto {
    private final Long id;
    private final String content;
    private final String author;
    private final LocalDateTime createdTime;

    public CommentListResponseDto(Comment entity) {
        this.id = entity.getCommentId();
        this.content = entity.getContent();
        this.author = entity.getUser().getNickname();
        this.createdTime = entity.getCreatedTime();
    }
}
