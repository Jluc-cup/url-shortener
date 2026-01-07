package com.urlshortener.service.impl;

import com.urlshortener.controller.dto.UrlShortItemRespV1;
import com.urlshortener.controller.dto.UrlShortListRespV1;
import com.urlshortener.controller.req.UrlShortCreateReqV1;
import com.urlshortener.dao.UrlDao;
import com.urlshortener.dao.UrlShortDao;
import com.urlshortener.dao.UserDao;
import com.urlshortener.model.entity.UrlEntity;
import com.urlshortener.model.entity.UrlShortEntity;
import com.urlshortener.model.entity.UserEntity;
import com.urlshortener.service.UrlShortService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UrlShortServiceImpl implements UrlShortService {

    private final UserDao userDao;
    private final UrlDao urlDao;
    private final UrlShortDao urlShortDao;

    private UrlShortServiceImpl self;

    @Autowired
    public void setSelf(@Lazy UrlShortServiceImpl self) {
        this.self = self;
    }

    @Override
    public int create(int userId, UrlShortCreateReqV1 req) {
        final UserEntity user = userDao.getById(userId);// race condition
        // todo descus about race condition hash generate retry ?
        return self.createTr(user, req);
    }

    @Transactional
    public int createTr(UserEntity user, UrlShortCreateReqV1 req) {
        final UrlEntity url = getOrCreate(req.originalUrl());
        final UrlShortEntity urlShort = UrlShortEntity.create(user, url, req, null);

        urlShortDao.save(urlShort);
        return urlShort.getId();
    }


    private UrlEntity getOrCreate(String originalUrl) { // race condition todo add redis lock
        UrlEntity url = urlDao.findByUrl(originalUrl);

        if (url != null) {
            return url;
        }

        url = UrlEntity.create(originalUrl);
        urlDao.save(url);
        return url;
    }

    @Override
    public void delete(int userId, int urlShortId) { // race condition todo
        final UrlShortEntity urlShort = urlShortDao.getByIdFetchUser(urlShortId);

        if (urlShort.getUser().getId() != userId) {
            throw new RuntimeException();
        }

        self.deleteSafeTr(urlShort);
    }


    @Transactional
    public void deleteSafeTr(UrlShortEntity urlShort) {
        urlShort.delete();
        urlShortDao.save(urlShort);
    }


    @Override
    public UrlShortListRespV1 getUserUrls(int userId, int page, int pageSize) {
        final List<UrlShortEntity> urlShortList = urlShortDao.getUserUrls(userId, page, pageSize);
        final int totalSize = urlShortDao.getCountByUserId(userId);

        final List<UrlShortItemRespV1> items = urlShortList.stream().map(UrlShortItemRespV1::new).toList();
        return new UrlShortListRespV1(items, totalSize);
    }
}
