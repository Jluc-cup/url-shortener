package com.urlshortener.dao.impl;


import com.urlshortener.dao.UrlShortDao;
import com.urlshortener.dao.repository.UrlShortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UrlShortDaoImpl implements UrlShortDao {

    private final UrlShortRepository repository;

}
