package com.urlshortener.dao;

import com.urlshortener.model.entity.UserEntity;

public interface UserDao {

    void saveAndFlush(UserEntity entity);

    boolean existByEmail(String email);

    UserEntity getById(int userId);

    UserEntity findById(int userId);

    UserEntity getByEmail(String email);

    UserEntity findByEmail(String email);

}
