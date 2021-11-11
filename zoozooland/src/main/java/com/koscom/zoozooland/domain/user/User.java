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

    @Column
    private String id;

    @Column
    private String password;

    @Builder
    public User(String nickname, String brokerage, String accountNumber, String id, String password) {
        this.nickname = nickname;
        this.brokerage = brokerage;
        this.accountNumber = accountNumber;
        this.id = id;
        this.password = password;
    }
}
