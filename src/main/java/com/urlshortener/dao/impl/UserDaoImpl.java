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


}
