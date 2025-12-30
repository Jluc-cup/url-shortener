package com.urlshortener.service.impl;

import com.urlshortener.controller.dto.SignInResp;
import com.urlshortener.controller.dto.SingUpResp;
import com.urlshortener.controller.req.SignInReq;
import com.urlshortener.controller.req.SignUpReq;
import com.urlshortener.dao.UserDao;
import com.urlshortener.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserDao userDao;


    @Override
    public SignInResp signIn(SignInReq req) {
        return null;
    }

    @Override
    public SingUpResp signUp(SignUpReq req) {
        return null;
    }
}
