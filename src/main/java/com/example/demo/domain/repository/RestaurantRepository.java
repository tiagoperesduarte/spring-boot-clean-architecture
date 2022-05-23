package com.example.demo.domain.repository;

import java.util.Optional;

import com.example.demo.domain.entity.Restaurant;
import com.example.demo.domain.entity.SimplePage;
import com.example.demo.domain.entity.SimplePageRequest;

public interface RestaurantRepository {
    SimplePage<Restaurant> findAll(SimplePageRequest simplePageRequest);

    Optional<Restaurant> findById(String id);

    Restaurant save(Restaurant restaurant);

    void deleteById(String id);
}
