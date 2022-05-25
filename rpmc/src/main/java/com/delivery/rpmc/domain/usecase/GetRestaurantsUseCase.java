package com.delivery.rpmc.domain.usecase;

import org.springframework.stereotype.Service;

import com.delivery.rpmc.domain.entity.Restaurant;
import com.delivery.rpmc.domain.entity.SimplePage;
import com.delivery.rpmc.domain.repository.RestaurantRepository;
import com.delivery.rpmc.domain.usecase.input.GetRestaurantsInput;

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
