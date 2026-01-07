package com.urlshortener.controller.dto;


import com.urlshortener.model.entity.UrlShortEntity;

public record UrlShortItemRespV1() {


    public UrlShortItemRespV1(UrlShortEntity e) {
        this();
    }
}
