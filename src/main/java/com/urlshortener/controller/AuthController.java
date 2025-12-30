package com.urlshortener.controller;

import com.urlshortener.controller.dto.IdResp;
import com.urlshortener.controller.req.UrlShortCreateReq;
import com.urlshortener.security.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {





    @PostMapping("/shorten")
    public IdResp create(@RequestBody UrlShortCreateReq req) {
        int userId = AuthUtil.getUserId();
        int urlShortId = urlShortService.create(userId, req);
        return new IdResp(urlShortId);
    }

}
