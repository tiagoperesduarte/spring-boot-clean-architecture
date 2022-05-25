package com.delivery.rpmc.domain.repository;

import java.util.Optional;

import com.delivery.rpmc.domain.entity.Restaurant;
import com.delivery.rpmc.domain.entity.SimplePage;
import com.delivery.rpmc.domain.entity.SimplePageRequest;

public interface RestaurantRepository {
    SimplePage<Restaurant> findAll(SimplePageRequest simplePageRequest);

    Optional<Restaurant> findById(String id);

    Restaurant save(Restaurant restaurant);

    void deleteById(String id);
}
