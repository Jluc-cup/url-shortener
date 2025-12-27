package com.urlshortener.security;


import com.urlshortener.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


@Getter
@Setter
public class AuthProfileContext extends User {

    private int userId;
    private String email;

    // this constructor spring security use
    public AuthProfileContext(String username, @Nullable String password,
                              Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    // this constructor spring security use
    public AuthProfileContext(String username, @Nullable String password, boolean enabled,
                              boolean accountNonExpired, boolean credentialsNonExpired,
                              boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public AuthProfileContext(Collection<GrantedAuthority> authorities, @NonNull UserEntity user) {
        super(user.getEmail(), user.getPassword(), authorities);
        this.userId = user.getId();
    }


    public static AuthProfileContext init(Collection<GrantedAuthority> authorities, @NonNull UserEntity user) {
        return new AuthProfileContext(authorities, user);
    }
}
