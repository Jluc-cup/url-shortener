package com.urlshortener.controller.dto;

import java.util.List;

public record UrlShortListResp(List<UrlShortItemResp> items, int totalSize) {
}
