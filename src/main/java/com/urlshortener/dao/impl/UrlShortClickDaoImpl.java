package com.urlshortener.dao.impl;


import com.urlshortener.dao.UrlShortClickDao;
import com.urlshortener.dao.repository.UrlShortClickRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;



@Repository
@RequiredArgsConstructor
public class UrlShortClickDaoImpl implements UrlShortClickDao {

    private final UrlShortClickRepository repository;
}
