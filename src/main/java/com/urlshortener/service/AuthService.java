package com.urlshortener.service;

import com.urlshortener.controller.dto.SignInResp;
import com.urlshortener.controller.dto.SingUpResp;
import com.urlshortener.controller.req.SignInReq;
import com.urlshortener.controller.req.SignUpReq;

public interface AuthService {

    SignInResp signIn(SignInReq req);

    SingUpResp signUp(SignUpReq req);
}
