package com.urlshortener.controller.req;


public record UrlShortCreateReq(String originalUrl,
                                String customAlias) {
}
