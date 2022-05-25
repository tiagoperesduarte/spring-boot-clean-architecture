package com.delivery.apmc.infrastructure.repository;

import org.springframework.stereotype.Repository;

import com.delivery.apmc.domain.entity.PaymentMethod;
import com.delivery.apmc.domain.repository.RestaurantPaymentMethodRepository;
import com.delivery.apmc.infrastructure.event.producer.UpdateRestaurantPaymentMethodProducer;
import com.delivery.apmc.infrastructure.event.producer.UpdateRestaurantsPaymentMethodProducer;
import com.delivery.apmc.infrastructure.event.producer.payload.UpdateRestaurantPaymentMethodPayload;
import com.delivery.apmc.infrastructure.event.producer.payload.UpdateRestaurantsPaymentMethodPayload;

@Repository
public class RestaurantPaymentMethodRepositoryImpl implements RestaurantPaymentMethodRepository {
    private final UpdateRestaurantPaymentMethodProducer updateRestaurantPaymentMethodProducer;
    private final UpdateRestaurantsPaymentMethodProducer updateRestaurantsPaymentMethodProducer;

    public RestaurantPaymentMethodRepositoryImpl(
            UpdateRestaurantPaymentMethodProducer updateRestaurantPaymentMethodProducer,
            UpdateRestaurantsPaymentMethodProducer updateRestaurantsPaymentMethodProducer
    ) {
        this.updateRestaurantPaymentMethodProducer = updateRestaurantPaymentMethodProducer;
        this.updateRestaurantsPaymentMethodProducer = updateRestaurantsPaymentMethodProducer;
    }

    @Override
    public void updateByRestaurantId(String restaurantId, PaymentMethod paymentMethod) {
        updateRestaurantPaymentMethodProducer.produce(UpdateRestaurantPaymentMethodPayload.of(restaurantId, paymentMethod));
    }

    @Override
    public void updateByAreaId(String areaId, PaymentMethod paymentMethod) {
        updateRestaurantsPaymentMethodProducer.produce(UpdateRestaurantsPaymentMethodPayload.of(areaId, paymentMethod));
    }
}
