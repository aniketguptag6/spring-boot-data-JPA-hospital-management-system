package com.project.ani.hospitalManagement.controller;

import com.project.ani.hospitalManagement.dto.LoginRequestDto;
import com.project.ani.hospitalManagement.dto.LoginResponseDto;
import com.project.ani.hospitalManagement.dto.SignUpRequestDto;
import com.project.ani.hospitalManagement.dto.SignupResponseDto;
import com.project.ani.hospitalManagement.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignUpRequestDto signUpRequestDto) {
        return ResponseEntity.ok(authService.signup(signUpRequestDto));
    }
}
