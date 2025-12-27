package com.urlshortener.dao;

import com.urlshortener.model.entity.TokenEntity;

public interface TokenDao {

    TokenEntity findByTokenFetchUser(String token);

    TokenEntity getByTokenFetchUser(String token);
}
