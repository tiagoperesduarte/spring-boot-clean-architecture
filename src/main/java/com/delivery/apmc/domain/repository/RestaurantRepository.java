package com.delivery.apmc.domain.repository;

import java.util.Optional;

import com.delivery.apmc.domain.entity.Restaurant;
import com.delivery.apmc.domain.entity.SimplePage;
import com.delivery.apmc.domain.entity.SimplePageRequest;

public interface RestaurantRepository {
    SimplePage<Restaurant> findAll(SimplePageRequest simplePageRequest);

    SimplePage<Restaurant> findAllByAreaId(String areaId, SimplePageRequest simplePageRequest);

    Optional<Restaurant> findById(String id);

    Restaurant save(Restaurant restaurant);

    void deleteById(String id);
}
