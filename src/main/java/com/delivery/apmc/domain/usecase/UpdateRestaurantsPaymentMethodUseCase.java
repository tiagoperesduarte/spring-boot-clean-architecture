package com.delivery.apmc.domain.usecase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.delivery.apmc.domain.entity.SimplePageRequest;
import com.delivery.apmc.domain.repository.RestaurantPaymentMethodRepository;
import com.delivery.apmc.domain.repository.RestaurantRepository;
import com.delivery.apmc.domain.usecase.input.UpdateRestaurantsPaymentMethodInput;

@Service
public class UpdateRestaurantsPaymentMethodUseCase {
    private final int batchSize;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantPaymentMethodRepository restaurantPaymentMethodRepository;

    public UpdateRestaurantsPaymentMethodUseCase(
            @Value("${app.restaurants-payment-method.batch.size}") int batchSize,
            RestaurantRepository restaurantRepository,
            RestaurantPaymentMethodRepository restaurantPaymentMethodRepository
    ) {
        this.batchSize = batchSize;
        this.restaurantRepository = restaurantRepository;
        this.restaurantPaymentMethodRepository = restaurantPaymentMethodRepository;
    }

    public void execute(UpdateRestaurantsPaymentMethodInput input) {
        var currentPage = 0;
        var hasNextPage = true;

        while (hasNextPage) {
            var simplePageRequest = new SimplePageRequest(currentPage, batchSize);
            var pageRestaurants = restaurantRepository.findAllByAreaId(
                    input.getAreaId(),
                    simplePageRequest
            );

            if (pageRestaurants.getTotalElements() > 0) {
                pageRestaurants.getContent()
                               .forEach(restaurant -> restaurantPaymentMethodRepository.updateByRestaurantId(
                                       restaurant.getId(),
                                       input.getPaymentMethod()
                               ));

                currentPage++;
            } else {
                hasNextPage = false;
            }
        }
    }
}
