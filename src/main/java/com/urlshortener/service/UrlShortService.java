package com.urlshortener.service;

import com.urlshortener.controller.dto.UrlShortListResp;
import com.urlshortener.controller.req.UrlShortCreateReq;

public interface UrlShortService {

    int create(int userId, UrlShortCreateReq req);

    void delete(int userId, int urlShortId);

    UrlShortListResp getUserUrls(int userId, int page, int pageSize);
}
