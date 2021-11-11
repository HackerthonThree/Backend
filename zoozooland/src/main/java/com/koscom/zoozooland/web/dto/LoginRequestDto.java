package com.koscom.zoozooland.web.dto;

import lombok.Getter;

@Getter
public class LoginRequestDto {
    private final String id;
    private final String password;

    public LoginRequestDto(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
