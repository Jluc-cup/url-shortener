package com.urlshortener.dao;

import com.urlshortener.model.entity.TokenEntity;

public interface TokenDao {

    void saveAndFlush(TokenEntity entity);

    TokenEntity findByTokenFetchUser(String token);

    TokenEntity getByTokenFetchUser(String token);

}
