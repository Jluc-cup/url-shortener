package com.urlshortener.controller.dto;

import java.util.List;

public record UrlShortListDto(List<UrlShortItemDto> items, int totalSize) {
}
