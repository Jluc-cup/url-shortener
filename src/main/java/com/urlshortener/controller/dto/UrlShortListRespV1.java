package com.urlshortener.controller.dto;

import java.util.List;

public record UrlShortListRespV1(List<UrlShortItemRespV1> items, int totalSize) {
}
