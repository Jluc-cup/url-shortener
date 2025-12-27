package com.urlshortener.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "url_short")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlShortEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(value = AccessType.PROPERTY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "url_id", nullable = false)
    private UrlEntity url;

    @Column(name = "original_url", nullable = false, length = 2048)
    private String originalUrl;

    @Column(name = "short_url", nullable = false, unique = true)
    private String shortUrl;

    @Column(name = "click_count")
    private int clickCount;

    @Column(name = "expires_at")
    private Instant expiresAt;

    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @OneToMany(mappedBy = "urlShort", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UrlShortClickEntity> clicks;

}