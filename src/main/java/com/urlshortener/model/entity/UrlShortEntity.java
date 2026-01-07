package com.urlshortener.model.entity;

import com.urlshortener.controller.req.UrlShortCreateReqV1;
import com.urlshortener.util.DateTimeUtil;
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

    @Column(name = "custom_alias", length = 120)
    private String customAlias;

    @Column(name = "short_url", nullable = false, unique = true)
    private String shortUrl;

    @Column(name = "click_count")
    private int clickCount;

    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "deleted", nullable = false)
    private Instant deleted;

    @OneToMany(mappedBy = "urlShort", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UrlShortClickEntity> clicks;

    public static UrlShortEntity create(UserEntity user,
                                        UrlEntity url,
                                        UrlShortCreateReqV1 req,
                                        String shortUrl) {
        return new UrlShortEntity(user, url, req, shortUrl);
    }

    public UrlShortEntity(UserEntity user, UrlEntity url, UrlShortCreateReqV1 req, String shortUrl) {
        this.user = user;
        this.url = url;
        originalUrl = url.getOriginalUrl();
        this.customAlias = req.customAlias();
        this.shortUrl = shortUrl;
        clickCount = 0;
        created = DateTimeUtil.getCurrent();
        deleted = null;
    }

    public void delete() {
        deleted = DateTimeUtil.getCurrent();
    }
}