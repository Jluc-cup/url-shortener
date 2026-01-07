package com.urlshortener.dao.repository;

import com.urlshortener.model.entity.UrlShortEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UrlShortRepository extends JpaRepository<UrlShortEntity, Integer> {

    @Query("SELECT u FROM UrlShortEntity u JOIN FETCH u.user WHERE u.id = :urlShortId")
    UrlShortEntity findByIdFetchUser(int urlShortId);

    @Query("SELECT u FROM UrlShortEntity u WHERE u.user.id = :userId")
    List<UrlShortEntity> getUserUrls(int userId, Pageable pageable);

    @Query("SELECT COUNT(u) FROM UrlShortEntity u WHERE u.user.id = :userId")
    int getCountByUserId(int userId);
}
