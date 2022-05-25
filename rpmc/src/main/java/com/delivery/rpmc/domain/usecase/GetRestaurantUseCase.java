package com.delivery.rpmc.domain.usecase;

import org.springframework.stereotype.Service;

import com.delivery.rpmc.domain.entity.Restaurant;
import com.delivery.rpmc.domain.exception.RestaurantNotFoundException;
import com.delivery.rpmc.domain.repository.RestaurantRepository;

@Service
public class GetRestaurantUseCase {
    private final RestaurantRepository restaurantRepository;

    public GetRestaurantUseCase(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant execute(String restaurantId) {
        return restaurantRepository.findById(restaurantId)
                                   .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with id " + restaurantId));
    }
}
