package com.urlshortener.dao;

import com.urlshortener.model.entity.UrlEntity;

public interface UrlDao {

    void save(UrlEntity entity);

    UrlEntity findByUrl(String url);

    UrlEntity getByUrl(String url);

}
