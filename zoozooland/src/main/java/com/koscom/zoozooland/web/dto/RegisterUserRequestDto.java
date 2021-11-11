package com.koscom.zoozooland.web.dto;

import com.koscom.zoozooland.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterUserRequestDto {
    private final String nickname;
    private final String brokerage;
    private final String accountNumber;
    private final String id;
    private final String password;

    @Builder
    public RegisterUserRequestDto(String nickname, String brokerage, String accountNumber, String id, String password) {
        this.nickname = nickname;
        this.brokerage = brokerage;
        this.accountNumber = accountNumber;
        this.id = id;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .nickname(nickname)
                .brokerage(brokerage)
                .accountNumber(accountNumber)
                .id(id)
                .password(password)
                .build();
    }
}
