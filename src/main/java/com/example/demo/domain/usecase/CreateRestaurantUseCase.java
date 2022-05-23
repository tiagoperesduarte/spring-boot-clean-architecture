package com.example.demo.domain.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Restaurant;
import com.example.demo.domain.repository.RestaurantRepository;
import com.example.demo.domain.usecase.input.CreateRestaurantInput;

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
