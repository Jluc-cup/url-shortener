package com.urlshortener.dao;

import com.urlshortener.model.entity.UrlShortEntity;

public interface UrlShortDao {
    void save(UrlShortEntity entity);

    UrlShortEntity getByIdFetchUser(int urlShortId);

    UrlShortEntity findByIdFetchUser(int urlShortId);
}
