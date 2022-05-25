package com.delivery.apmc.domain.usecase;

import org.springframework.stereotype.Service;

import com.delivery.apmc.domain.entity.Restaurant;
import com.delivery.apmc.domain.entity.SimplePage;
import com.delivery.apmc.domain.repository.RestaurantRepository;
import com.delivery.apmc.domain.usecase.input.GetRestaurantsInput;

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
