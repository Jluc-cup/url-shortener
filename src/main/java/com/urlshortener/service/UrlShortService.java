package com.urlshortener.service;

import com.urlshortener.controller.dto.UrlShortListRespV1;
import com.urlshortener.controller.req.UrlShortCreateReqV1;

public interface UrlShortService {

    int create(int userId, UrlShortCreateReqV1 req);

    void delete(int userId, int urlShortId);

    UrlShortListRespV1 getUserUrls(int userId, int page, int pageSize);
}
