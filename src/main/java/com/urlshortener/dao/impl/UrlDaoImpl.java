package com.urlshortener.dao.impl;

import com.urlshortener.dao.UrlDao;
import com.urlshortener.dao.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UrlDaoImpl implements UrlDao {

    private final UrlRepository repository;

}
