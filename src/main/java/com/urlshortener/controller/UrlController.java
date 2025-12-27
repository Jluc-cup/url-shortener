package com.urlshortener.controller;

import com.urlshortener.controller.dto.IdDto;
import com.urlshortener.controller.dto.UrlShortListDto;
import com.urlshortener.controller.req.UrlShortCreateReq;
import com.urlshortener.security.AuthUtil;
import com.urlshortener.service.UrlShortService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/url")
@RequiredArgsConstructor
public class UrlController {


    private final UrlShortService urlShortService;


    @PostMapping("/shorten")
    public IdDto create(@RequestBody UrlShortCreateReq req) {
        int userId = AuthUtil.getUserId();
        int urlShortId = urlShortService.create(userId, req);
        return new IdDto(urlShortId);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        int userId = AuthUtil.getUserId();
        urlShortService.delete(userId, id);
    }


    @GetMapping("/my")
    public UrlShortListDto getUserUrls(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int pageSize) {
        int userId = AuthUtil.getUserId();
        return urlShortService.getUserUrls(userId,page,pageSize);
    }


//    @GetMapping("/{shortCode}")
//    public void redirectToOriginal(@PathVariable String shortCode) {
//        final String originalUrl = urlShortService.redirectToOriginal(shortCode);
//        return ResponseEntity.status(HttpStatus.FOUND)
//                .location(URI.create(originalUrl))
//                .build();
//    }

}
