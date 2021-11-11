package com.koscom.zoozooland.domain.comment;

import com.koscom.zoozooland.domain.BaseTimeEntity;
import com.koscom.zoozooland.domain.stock.Stock;
import com.koscom.zoozooland.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Stock stock;

    @Builder
    public Comment(String content, User author, Stock stock) {
        this.content = content;
        this.user = author;
        this.stock = stock;
    }
}