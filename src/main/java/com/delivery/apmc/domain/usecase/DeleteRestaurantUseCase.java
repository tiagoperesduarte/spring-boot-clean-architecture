package com.delivery.apmc.domain.usecase;

import org.springframework.stereotype.Service;

import com.delivery.apmc.domain.repository.RestaurantRepository;

@Service
public class DeleteRestaurantUseCase {
    private final RestaurantRepository restaurantRepository;

    public DeleteRestaurantUseCase(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void execute(String restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }
}
