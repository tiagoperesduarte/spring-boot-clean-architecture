package com.example.demo.domain.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Restaurant;
import com.example.demo.domain.entity.SimplePage;
import com.example.demo.domain.repository.RestaurantRepository;
import com.example.demo.domain.usecase.input.GetRestaurantsInput;

@Service
public class GetRestaurantsUseCase {
    private final RestaurantRepository restaurantRepository;

    public GetRestaurantsUseCase(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public SimplePage<Restaurant> execute(GetRestaurantsInput input) {
        return restaurantRepository.findAll(input.toEntity());
    }
}
