package com.urlshortener.dao.repository;

import com.urlshortener.model.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<TokenEntity, Integer> {

    Optional<TokenEntity> findByToken(String token);

    boolean existsByToken(String token);
}
