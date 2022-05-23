package com.example.demo.domain.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Restaurant;
import com.example.demo.domain.exception.RestaurantNotFoundException;
import com.example.demo.domain.repository.RestaurantRepository;

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
