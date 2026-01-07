package com.urlshortener.controller.dto;


import com.urlshortener.model.entity.UrlShortEntity;

public record UrlShortItemResp() {


    public UrlShortItemResp(UrlShortEntity e) {
        this();
    }
}
