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
    public void saveAndFlush(UserEntity entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public boolean existByEmail(String email) {
        return repository.existByEmail(email);
    }

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

    @Override
    public UserEntity getByEmail(String email) {
        final UserEntity entity = findByEmail(email);
        if (entity == null) {
            throw new RuntimeException();
        }
        return entity;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
