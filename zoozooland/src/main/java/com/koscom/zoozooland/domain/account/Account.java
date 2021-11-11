package com.koscom.zoozooland.domain.account;

import com.koscom.zoozooland.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @OneToOne
    @JoinColumn
    private User user;

    @Column
    private String stockName;

    @Column
    private Long qty;

    @Builder
    public Account(User user, String stockName, Long qty) {
        this.user = user;
        this.stockName = stockName;
        this.qty = qty;
    }
}
