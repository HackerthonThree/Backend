package com.koscom.zoozooland.web.dto;

import com.koscom.zoozooland.domain.comment.Comment;
import com.koscom.zoozooland.domain.stock.Stock;
import com.koscom.zoozooland.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CommentSaveRequestDto {

    private final String content;
    private final String nickname;
    private final String stockName;

    @Builder
    public CommentSaveRequestDto(String content, String nickname, String stockName) {
        this.content = content;
        this.nickname = nickname;
        this.stockName = stockName;
    }

    public Comment toEntity(User user, Stock stock) {
        return Comment.builder()
                .content(this.content)
                .author(user)
                .stock(stock)
                .build();
    }
}
