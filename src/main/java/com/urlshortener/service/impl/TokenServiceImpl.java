package com.urlshortener.service.impl;

import com.urlshortener.dao.TokenDao;
import com.urlshortener.dao.UserDao;
import com.urlshortener.model.entity.TokenEntity;
import com.urlshortener.model.entity.UserEntity;
import com.urlshortener.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenDao tokenDao;
    private final UserDao userDao;

    @Override
    public TokenEntity generate(UserEntity user) {
        return null;
    }
}
