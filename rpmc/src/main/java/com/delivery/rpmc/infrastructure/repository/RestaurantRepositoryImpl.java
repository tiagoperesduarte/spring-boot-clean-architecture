package com.delivery.rpmc.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.delivery.rpmc.domain.entity.Restaurant;
import com.delivery.rpmc.domain.entity.SimplePage;
import com.delivery.rpmc.domain.entity.SimplePageRequest;
import com.delivery.rpmc.domain.repository.RestaurantRepository;
import com.delivery.rpmc.infrastructure.storage.document.RestaurantDocument;
import com.delivery.rpmc.infrastructure.storage.repository.RestaurantMongoRepository;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {
    private final RestaurantMongoRepository restaurantMongoRepository;

    public RestaurantRepositoryImpl(RestaurantMongoRepository restaurantMongoRepository) {
        this.restaurantMongoRepository = restaurantMongoRepository;
    }

    @Override
    public SimplePage<Restaurant> findAll(SimplePageRequest simplePageRequest) {
        var pageRequest = PageRequest.of(simplePageRequest.getPage(), simplePageRequest.getSize());
        var page = restaurantMongoRepository.findAll(pageRequest)
                                            .map(RestaurantDocument::toEntity);

        return new SimplePage<>(page.getContent(), page.getTotalElements());
    }

    @Override
    public Optional<Restaurant> findById(String id) {
        return restaurantMongoRepository.findById(id)
                                        .map(RestaurantDocument::toEntity);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        var savedRestaurantDocument = restaurantMongoRepository.save(RestaurantDocument.of(restaurant));
        return savedRestaurantDocument.toEntity();
    }

    @Override
    public void deleteById(String id) {
        restaurantMongoRepository.deleteById(id);
    }
}
