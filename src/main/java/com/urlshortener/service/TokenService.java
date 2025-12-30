package com.urlshortener.service;

import com.urlshortener.model.entity.TokenEntity;
import com.urlshortener.model.entity.UserEntity;

public interface TokenService {

    TokenEntity generate(UserEntity user);
}
