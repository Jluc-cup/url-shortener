package com.urlshortener.dao.impl;

import com.urlshortener.dao.UrlDao;
import com.urlshortener.dao.repository.UrlRepository;
import com.urlshortener.model.entity.UrlEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UrlDaoImpl implements UrlDao {

    private final UrlRepository repository;


    @Override
    public void save(UrlEntity entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public UrlEntity findByUrl(String url) {
        return repository.findByUrl(url);
    }

    @Override
    public UrlEntity getByUrl(String url) {
        final UrlEntity entity = findByUrl(url);
        if (entity == null) {
            throw new RuntimeException();
        }
        return entity;
    }
}
