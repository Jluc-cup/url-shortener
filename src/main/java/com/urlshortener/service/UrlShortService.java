package com.urlshortener.service;

import com.urlshortener.controller.dto.UrlShortListDto;
import com.urlshortener.controller.req.UrlShortCreateReq;

public interface UrlShortService {

    int create(int userId, UrlShortCreateReq req);

    void delete(int userId, int urlShortId);

    UrlShortListDto getUserUrls(int userId, int page, int pageSize);
}
