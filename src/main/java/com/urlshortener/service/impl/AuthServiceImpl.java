package com.urlshortener.service.impl;

import com.urlshortener.controller.dto.SignInRespV1;
import com.urlshortener.controller.dto.SignUpRespV1;
import com.urlshortener.controller.req.SignInReqV1;
import com.urlshortener.controller.req.SignUpReqV1;
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
    public SignInRespV1 signIn(SignInReqV1 req) {
        final UserEntity user = userDao.getByEmail(req.email());

        if (user == null) {
            throw new RuntimeException();
        }

        final TokenEntity token = tokenService.generate(user);
        return new SignInRespV1(token.getToken(), null);
    }

    @Override
    public SignUpRespV1 signUp(SignUpReqV1 req) {
        if (userDao.existByEmail(req.email())) {
            throw new RuntimeException();
        }
        return self.singUpTr(req);
    }

    @Transactional
    public SignUpRespV1 singUpTr(SignUpReqV1 req) {
        final UserEntity user = UserEntity.create(req);
        userDao.saveAndFlush(user);
        final TokenEntity token = tokenService.generate(user);
        return new SignUpRespV1(token.getToken(), null);
    }

}
