package com.urlshortener.dao;

import com.urlshortener.model.entity.UserEntity;

public interface UserDao {

    UserEntity getById(int userId);

    UserEntity findById(int userId);
}
