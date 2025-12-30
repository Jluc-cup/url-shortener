package com.urlshortener.model.entity;

import com.urlshortener.util.DateTimeUtil;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.Instant;

import static com.urlshortener.util.StringUtil.uuidGenerate;

@Entity
@Table(name = "token")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(value = AccessType.PROPERTY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "token", nullable = false, unique = true, length = 512)
    private String token;

    @Column(name = "created", nullable = false)
    private Instant created;


    public static TokenEntity generate(UserEntity user) {
        return new TokenEntity(user);
    }


    private TokenEntity(UserEntity user) {
        this.user = user;
        this.token = uuidGenerate();
        created = DateTimeUtil.getCurrent();
    }
}
