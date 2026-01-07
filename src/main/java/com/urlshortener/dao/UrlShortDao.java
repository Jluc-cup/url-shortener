package com.urlshortener.dao;

import com.urlshortener.model.entity.UrlShortEntity;

import java.util.List;

public interface UrlShortDao {
    void save(UrlShortEntity entity);

    UrlShortEntity getByIdFetchUser(int urlShortId);

    UrlShortEntity findByIdFetchUser(int urlShortId);

    List<UrlShortEntity> getUserUrls(int userId, int page, int pageSize);

    int getCountByUserId(int userId);
}
