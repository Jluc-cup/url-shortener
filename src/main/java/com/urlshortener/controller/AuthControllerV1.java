package com.urlshortener.controller;

import com.urlshortener.controller.dto.SignInRespV1;
import com.urlshortener.controller.dto.SignUpRespV1;
import com.urlshortener.controller.req.SignInReqV1;
import com.urlshortener.controller.req.SignUpReqV1;
import com.urlshortener.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class AuthControllerV1 {

    private final AuthService authService;

    @PostMapping("/api/v1/auth/action/signIn")
    public SignInRespV1 signIn(@RequestBody SignInReqV1 req) {
        return authService.signIn(req);
    }

    @PostMapping("/api/v1/auth/action/signUp")
    public SignUpRespV1 signUp(@RequestBody SignUpReqV1 req) {
        return authService.signUp(req);
    }

}
