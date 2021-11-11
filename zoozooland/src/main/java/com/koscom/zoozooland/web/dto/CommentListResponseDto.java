package com.koscom.zoozooland.web.dto;

import com.koscom.zoozooland.domain.comment.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class CommentListResponseDto implements Comparable<CommentListResponseDto>{
    private final Long id;
    private final String content;
    private final String author;
    private final LocalDateTime createdTime;

    @Setter
    private Long earn;

    public CommentListResponseDto(Comment entity) {
        this.id = entity.getCommentId();
        this.content = entity.getContent();
        this.author = entity.getUser().getNickname();
        this.createdTime = entity.getCreatedTime();
    }

    // 수익금이 높은 사람이 더 우선적으로 정렬
    @Override
    public int compareTo(CommentListResponseDto o) {
        return (int)(o.earn - this.earn);
    }
}
