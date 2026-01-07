package com.urlshortener.auth;

import com.urlshortener.envn.ITBaseTestV1;
import com.urlshortener.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthBaseITTestV1 extends ITBaseTestV1 {

    @Autowired
    private AuthService authService;
}
