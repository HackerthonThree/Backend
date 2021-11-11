package com.koscom.zoozooland.domain.user;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column
    private String nickname;

    @Column
    private String brokerage;

    @Column
    private String accountNumber;

    @Builder
    public User(String nickname, String brokerage, String accountNumber) {
        this.nickname = nickname;
        this.brokerage = brokerage;
        this.accountNumber = accountNumber;
    }
}
