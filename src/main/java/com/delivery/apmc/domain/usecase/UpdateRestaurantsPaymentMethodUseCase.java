package com.delivery.apmc.domain.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.delivery.apmc.domain.entity.PaymentMethod;
import com.delivery.apmc.domain.entity.Restaurant;
import com.delivery.apmc.domain.entity.SimplePageRequest;
import com.delivery.apmc.domain.repository.RestaurantPaymentMethodRepository;
import com.delivery.apmc.domain.repository.RestaurantRepository;
import com.delivery.apmc.domain.usecase.input.UpdateRestaurantsPaymentMethodInput;

@Service
public class UpdateRestaurantsPaymentMethodUseCase {
    private final int batchSize;
    private final String updateType;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantPaymentMethodRepository restaurantPaymentMethodRepository;

    public UpdateRestaurantsPaymentMethodUseCase(
            @Value("${app.restaurants-payment-method.batch.size}") int batchSize,
            @Value("${app.restaurants-payment-method.update.type}") String updateType,
            RestaurantRepository restaurantRepository,
            RestaurantPaymentMethodRepository restaurantPaymentMethodRepository
    ) {
        this.batchSize = batchSize;
        this.updateType = updateType;
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

            if (pageRestaurants.getContent().size() > 0) {
                updateRestaurants(pageRestaurants.getContent(), input.getPaymentMethod());
                currentPage++;
            } else {
                hasNextPage = false;
            }
        }
    }

    private void updateRestaurants(List<Restaurant> restaurants, PaymentMethod paymentMethod) {
        if (updateType.equalsIgnoreCase("single")) {
            updateRestaurantsOneByOne(restaurants, paymentMethod);
        } else {
            updateRestaurantsInBatch(restaurants, paymentMethod);
        }
    }

    private void updateRestaurantsOneByOne(List<Restaurant> restaurants, PaymentMethod paymentMethod) {
        restaurants.forEach(restaurant -> restaurantPaymentMethodRepository.updateByRestaurantIds(
                List.of(restaurant.getId()),
                paymentMethod
        ));
    }

    private void updateRestaurantsInBatch(List<Restaurant> restaurants, PaymentMethod paymentMethod) {
        var restaurantIds = restaurants.stream()
                                       .map(Restaurant::getId)
                                       .toList();

        restaurantPaymentMethodRepository.updateByRestaurantIds(restaurantIds, paymentMethod);
    }
}
