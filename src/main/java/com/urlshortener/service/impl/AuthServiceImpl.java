package com.urlshortener.service.impl;

import com.urlshortener.controller.dto.SignInResp;
import com.urlshortener.controller.dto.SignUpResp;
import com.urlshortener.controller.req.SignInReq;
import com.urlshortener.controller.req.SignUpReq;
import com.urlshortener.dao.UserDao;
import com.urlshortener.model.entity.TokenEntity;
import com.urlshortener.model.entity.UserEntity;
import com.urlshortener.service.AuthService;
import com.urlshortener.service.TokenService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserDao userDao;

    private final TokenService tokenService;

    private AuthServiceImpl self;

    @Autowired
    public void setSelf(@Lazy AuthServiceImpl self) {
        this.self = self;
    }

    @Override
    public SignInResp signIn(SignInReq req) {
        final UserEntity user = userDao.getByEmail(req.email());

        if (user == null) {
            throw new RuntimeException();
        }

        final TokenEntity token = tokenService.generate(user);
        return new SignInResp(token.getToken(), null);
    }

    @Override
    public SignUpResp signUp(SignUpReq req) {
        if (userDao.existByEmail(req.email())) {
            throw new RuntimeException();
        }
        return self.singUpTr(req);
    }

    @Transactional
    public SignUpResp singUpTr(SignUpReq req) {
        final UserEntity user = UserEntity.create(req);
        userDao.saveAndFlush(user);
        final TokenEntity token = tokenService.generate(user);
        return new SignUpResp(token.getToken(), null);
    }

}
