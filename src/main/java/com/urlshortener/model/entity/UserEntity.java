package com.urlshortener.model.entity;

import com.urlshortener.controller.req.SignUpReqV1;
import com.urlshortener.util.DateTimeUtil;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(value = AccessType.PROPERTY)
    private int id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created", nullable = false)
    private Instant created;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UrlShortEntity> urlShorts;

    public static UserEntity create(SignUpReqV1 req) {
        return new UserEntity(req);
    }

    public UserEntity(SignUpReqV1 req) {
        this.email = req.email();
        this.password = req.password();
        created = DateTimeUtil.getCurrent();
    }
}