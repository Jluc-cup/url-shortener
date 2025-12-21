package com.urlshortener.dao.repository;

import com.urlshortener.model.entity.UrlShortEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UrlShortRepository extends JpaRepository<UrlShortEntity, Integer> {

}
