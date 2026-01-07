package com.urlshortener.controller.req;


public record UrlShortCreateReqV1(String originalUrl,
                                  String customAlias) {
}
