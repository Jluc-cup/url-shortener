package com.urlshortener.security;


import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class AuthUtil {

    private static AuthProfileContext getCurrent() {
        return (AuthProfileContext)
                Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication())
                        .getPrincipal();
    }

    public Integer getSafeUserId() {
        final AuthProfileContext profileContext = getCurrent();
        if (profileContext == null) {
            return null;
        }
        return profileContext.getUserId();
    }

    public int getUserId() {
        final AuthProfileContext profileContext = getCurrent();
        if (profileContext == null) {
            throw new RuntimeException();
        }
        return profileContext.getUserId();
    }
}

