package com.koscom.zoozooland.service;

import com.koscom.zoozooland.domain.user.UserRepository;
import com.koscom.zoozooland.web.dto.LoginRequestDto;
import com.koscom.zoozooland.web.dto.RegisterUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    // 닉네임 중복 체크
    @Transactional
    public boolean isRedundant(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    // 회원 가입
    @Transactional
    public Long registerUser(RegisterUserRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getUserId();
    }

    // 로그인
    @Transactional
    public Long login(LoginRequestDto requestDto) {
        if (userRepository.existsByIdAndPassword(requestDto.getId(), requestDto.getPassword()))
            return userRepository.findByIdAndPassword(requestDto.getId(), requestDto.getPassword()).getUserId();
        else
            return 0L;
    }
}
