package com.urlshortener.controller;

import com.urlshortener.controller.dto.SignInResp;
import com.urlshortener.controller.dto.SignUpResp;
import com.urlshortener.controller.req.SignInReq;
import com.urlshortener.controller.req.SignUpReq;
import com.urlshortener.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/api/v1/auth/action/signIn")
    public SignInResp signIn(@RequestBody SignInReq req) {
        return authService.signIn(req);
    }

    @PostMapping("/api/v1/auth/action/signUp")
    public SignUpResp signUp(@RequestBody SignUpReq req) {
        return authService.signUp(req);
    }

}
