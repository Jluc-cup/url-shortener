package com.urlshortener.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "url")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(value = AccessType.PROPERTY)
    private int id;

    @Column(name = "original_url", nullable = false, length = 2048)
    private String originalUrl;

    @Column(name = "domain")
    private String domain;

    @Column(name = "region")
    private String region;

    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "is_blocked", nullable = false)
    private boolean isBlocked;

    @OneToMany(mappedBy = "url", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UrlShortEntity> urlShorts;

}