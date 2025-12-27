package com.urlshortener.dao.repository;

import com.urlshortener.model.entity.UrlShortEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UrlShortRepository extends JpaRepository<UrlShortEntity, Integer> {

    @Query("SELECT u FROM UrlShortEntity u JOIN FETCH u.user WHERE u.id = :urlShortId")
    UrlShortEntity findByIdFetchUser(int urlShortId);
}
