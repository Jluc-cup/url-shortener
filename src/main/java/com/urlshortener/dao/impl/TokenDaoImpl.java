package com.urlshortener.dao.impl;

import com.urlshortener.dao.TokenDao;
import com.urlshortener.dao.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TokenDaoImpl implements TokenDao {

    private final TokenRepository repository;

}
