package com.urlshortener.controller;

import com.urlshortener.controller.dto.IdRespV1;
import com.urlshortener.controller.dto.UrlShortListRespV1;
import com.urlshortener.controller.req.UrlShortCreateReqV1;
import com.urlshortener.security.AuthUtil;
import com.urlshortener.service.UrlShortService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class UrlControllerV1 {


    private final UrlShortService urlShortService;


    @PostMapping("/api/v1/url/shorten")
    public IdRespV1 create(@RequestBody UrlShortCreateReqV1 req) {
        int userId = AuthUtil.getUserId();
        int urlShortId = urlShortService.create(userId, req);
        return new IdRespV1(urlShortId);
    }


    @DeleteMapping("/api/v1/url/shorten/{shortenId}")
    public void delete(@PathVariable int shortenId) {
        int userId = AuthUtil.getUserId();
        urlShortService.delete(userId, shortenId);
    }


    @GetMapping("/api/v1/url/shorten/my")
    public UrlShortListRespV1 getUserUrls(@RequestParam(defaultValue = "0") int page,
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
