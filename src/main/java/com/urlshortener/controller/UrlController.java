package com.urlshortener.controller;

import com.urlshortener.controller.dto.IdResp;
import com.urlshortener.controller.dto.UrlShortListResp;
import com.urlshortener.controller.req.UrlShortCreateReq;
import com.urlshortener.security.AuthUtil;
import com.urlshortener.service.UrlShortService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class UrlController {


    private final UrlShortService urlShortService;


    @PostMapping("/api/v1/url/shorten")
    public IdResp create(@RequestBody UrlShortCreateReq req) {
        int userId = AuthUtil.getUserId();
        int urlShortId = urlShortService.create(userId, req);
        return new IdResp(urlShortId);
    }


    @DeleteMapping("/api/v1/url/shorten/{shortenId}")
    public void delete(@PathVariable int shortenId) {
        int userId = AuthUtil.getUserId();
        urlShortService.delete(userId, shortenId);
    }


    @GetMapping("/api/v1/url/shorten/my")
    public UrlShortListResp getUserUrls(@RequestParam(defaultValue = "0") int page,
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
