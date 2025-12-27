package com.urlshortener.dao.repository;

import com.urlshortener.model.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<TokenEntity, Integer> {

    @Query("SELECT t FROM TokenEntity t JOIN FETCH t.user WHERE t.token = :token")
    TokenEntity findByTokenFetchUser(String token);
}
