package com.urlshortener.dao.impl;


import com.urlshortener.dao.UrlShortDao;
import com.urlshortener.dao.repository.UrlShortRepository;
import com.urlshortener.model.entity.UrlShortEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
@RequiredArgsConstructor
public class UrlShortDaoImpl implements UrlShortDao {

    private final UrlShortRepository repository;

    @Override
    public void save(UrlShortEntity entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public UrlShortEntity getByIdFetchUser(int urlShortId) {
        final UrlShortEntity entity = findByIdFetchUser(urlShortId);
        if (entity == null) {
            throw new RuntimeException();
        }
        return entity;
    }

    @Override
    public UrlShortEntity findByIdFetchUser(int urlShortId) {
        return repository.findByIdFetchUser(urlShortId);
    }

    @Override
    public List<UrlShortEntity> getUserUrls(int userId, int page, int pageSize) {
        final Pageable pageable = PageRequest.of(page, pageSize);
        return repository.getUserUrls(userId, pageable);
    }

    @Override
    public int getCountByUserId(int userId) {
        return repository.getCountByUserId(userId);
    }
}
