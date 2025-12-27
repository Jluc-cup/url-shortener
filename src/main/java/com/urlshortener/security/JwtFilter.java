package com.urlshortener.security;

import com.urlshortener.dao.TokenDao;
import com.urlshortener.model.entity.TokenEntity;
import com.urlshortener.model.entity.UserEntity;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Component
@Order(2)
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final TokenDao tokenDao;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null && !token.isEmpty()) {
            final TokenEntity tokenEntity = tokenDao.getByTokenFetchUser(token);

            if (tokenEntity == null) {
                throw new RuntimeException();
            }

            final UserEntity user = tokenEntity.getUser();

            setInfoToAuthContext(user);
        }

        filterChain.doFilter(request, response);
    }

    private void setInfoToAuthContext(UserEntity user) {
        final Collection<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

        final AuthProfileContext userDetails =
                AuthProfileContext.init(authorities, user);

        final UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
