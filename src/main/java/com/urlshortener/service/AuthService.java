package com.urlshortener.service;

import com.urlshortener.controller.dto.SignInResp;
import com.urlshortener.controller.dto.SignUpResp;
import com.urlshortener.controller.req.SignInReq;
import com.urlshortener.controller.req.SignUpReq;

public interface AuthService {

    SignInResp signIn(SignInReq req);

    SignUpResp signUp(SignUpReq req);
}
