package com.urlshortener.dao.repository;

import com.urlshortener.model.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlEntity, Integer> {

    @Query("SELECT u FROM UrlEntity u WHERE u.originalUrl = :url")
    UrlEntity findByUrl(String url);
}
