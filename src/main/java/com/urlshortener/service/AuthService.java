package com.urlshortener.service;

import com.urlshortener.controller.dto.SignInRespV1;
import com.urlshortener.controller.dto.SignUpRespV1;
import com.urlshortener.controller.req.SignInReqV1;
import com.urlshortener.controller.req.SignUpReqV1;

public interface AuthService {

    SignInRespV1 signIn(SignInReqV1 req);

    SignUpRespV1 signUp(SignUpReqV1 req);
}
