package com.urlshortener.model.entity;

import com.urlshortener.model.enums.DeviceType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "url_short_click")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlShortClickEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(value = AccessType.PROPERTY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "url_short_id", nullable = false)
    private UrlShortEntity urlShort;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "country_code", length = 2)
    private String countryCode;

    @Column(name = "referrer", length = 2048)
    private String referrer;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_type")
    private DeviceType DeviceType;

    @Column(name = "browser")
    private String browser;

    @Column(name = "created", nullable = false)
    private Instant created;

}