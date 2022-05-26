package com.delivery.apmc.domain.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.delivery.apmc.domain.usecase.input.CreateRestaurantInput;
import com.delivery.apmc.domain.usecase.input.GenerateFakeRestaurantsInput;

@Service
public class GenerateFakeRestaurantsUseCase {
    private final CreateRestaurantUseCase createRestaurantUseCase;

    public GenerateFakeRestaurantsUseCase(CreateRestaurantUseCase createRestaurantUseCase) {
        this.createRestaurantUseCase = createRestaurantUseCase;
    }

    public void execute(GenerateFakeRestaurantsInput input) {
        for (int i = 0; i < input.getQuantity(); i++) {
            var name = String.format("Restaurant %s", i + 1);
            var areaIds = List.of(input.getAreaId());

            createRestaurantUseCase.execute(new CreateRestaurantInput(name, areaIds));
        }
    }
}
