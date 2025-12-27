package com.urlshortener.dao.impl;

import com.urlshortener.dao.UserDao;
import com.urlshortener.dao.repository.UserRepository;
import com.urlshortener.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final UserRepository repository;


    @Override
    public UserEntity getById(int userId) {
        final UserEntity entity = findById(userId);
        if (entity == null) {
            throw new RuntimeException();
        }
        return entity;
    }

    @Override
    public UserEntity findById(int userId) {
        return repository.findById(userId).orElse(null);
    }
}
