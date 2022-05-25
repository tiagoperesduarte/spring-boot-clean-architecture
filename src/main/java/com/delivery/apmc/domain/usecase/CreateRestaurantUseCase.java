package com.delivery.apmc.domain.usecase;

import org.springframework.stereotype.Service;

import com.delivery.apmc.domain.entity.Restaurant;
import com.delivery.apmc.domain.repository.RestaurantRepository;
import com.delivery.apmc.domain.usecase.input.CreateRestaurantInput;

@Service
public class CreateRestaurantUseCase {
    private final RestaurantRepository restaurantRepository;

    public CreateRestaurantUseCase(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant execute(CreateRestaurantInput input) {
        return restaurantRepository.save(input.toEntity());
    }
}
