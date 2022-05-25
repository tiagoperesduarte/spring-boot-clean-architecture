package com.delivery.apmc.domain.usecase;

import org.springframework.stereotype.Service;

import com.delivery.apmc.domain.entity.Restaurant;
import com.delivery.apmc.domain.exception.RestaurantNotFoundException;
import com.delivery.apmc.domain.repository.RestaurantRepository;

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
