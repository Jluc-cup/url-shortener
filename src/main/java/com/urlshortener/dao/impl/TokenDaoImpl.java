package com.urlshortener.dao.impl;

import com.urlshortener.dao.TokenDao;
import com.urlshortener.dao.repository.TokenRepository;
import com.urlshortener.model.entity.TokenEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TokenDaoImpl implements TokenDao {

    private final TokenRepository repository;


    @Override
    public TokenEntity findByTokenFetchUser(String token) {
        return repository.findByTokenFetchUser(token);
    }

    @Override
    public TokenEntity getByTokenFetchUser(String token) {

        final TokenEntity tokenEntity = findByTokenFetchUser(token);
        if (tokenEntity == null) {
            throw new RuntimeException();
        }
        return tokenEntity;
    }
}
