package com.example.demo.infrastructure.storage.repository.impl;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.Restaurant;
import com.example.demo.domain.entity.SimplePage;
import com.example.demo.domain.entity.SimplePageRequest;
import com.example.demo.domain.repository.RestaurantRepository;
import com.example.demo.infrastructure.storage.document.RestaurantDocument;
import com.example.demo.infrastructure.storage.repository.RestaurantMongoRepository;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {
    private final RestaurantMongoRepository repository;

    public RestaurantRepositoryImpl(RestaurantMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public SimplePage<Restaurant> findAll(SimplePageRequest simplePageRequest) {
        var pageRequest = PageRequest.of(simplePageRequest.getPage(), simplePageRequest.getSize());
        var page = repository.findAll(pageRequest)
                             .map(RestaurantDocument::toEntity);

        return new SimplePage<>(page.getContent(), page.getTotalElements());
    }

    @Override
    public Optional<Restaurant> findById(String id) {
        return repository.findById(id)
                         .map(RestaurantDocument::toEntity);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        var savedRestaurantDocument = repository.save(RestaurantDocument.of(restaurant));
        return savedRestaurantDocument.toEntity();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
