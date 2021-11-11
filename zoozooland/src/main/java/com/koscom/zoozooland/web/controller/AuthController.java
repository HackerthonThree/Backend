package com.koscom.zoozooland.web.controller;

import com.koscom.zoozooland.service.AuthService;
import com.koscom.zoozooland.web.dto.LoginRequestDto;
import com.koscom.zoozooland.web.dto.RegisterUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // 닉네임 중복 체크
    @GetMapping("/redundant")
    public boolean isRedundant(@RequestParam String nickname) {
        return authService.isRedundant(nickname);
    }

    // 회원 가입
    @PostMapping("/register")
    public Long registerUser(@RequestBody RegisterUserRequestDto requestDto) {
        return authService.registerUser(requestDto);
    }

    // 로그인
    @GetMapping("/login")
    public Long login(@RequestBody LoginRequestDto requestDto) {
        return authService.login(requestDto);
    }
}
