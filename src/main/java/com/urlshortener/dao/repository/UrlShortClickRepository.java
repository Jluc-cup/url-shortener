package com.urlshortener.dao.repository;

import com.urlshortener.model.entity.UrlShortClickEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrlShortClickRepository extends JpaRepository<UrlShortClickEntity, Integer> {

}
