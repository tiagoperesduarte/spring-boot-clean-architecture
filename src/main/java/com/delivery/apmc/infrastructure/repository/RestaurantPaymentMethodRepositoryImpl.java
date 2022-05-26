package com.delivery.apmc.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.delivery.apmc.domain.entity.PaymentMethod;
import com.delivery.apmc.domain.repository.RestaurantPaymentMethodRepository;
import com.delivery.apmc.infrastructure.event.producer.UpdateRestaurantsPaymentMethodBatchProducer;
import com.delivery.apmc.infrastructure.event.producer.UpdateRestaurantsPaymentMethodProducer;
import com.delivery.apmc.infrastructure.event.producer.payload.UpdateRestaurantsPaymentMethodBatchPayload;
import com.delivery.apmc.infrastructure.event.producer.payload.UpdateRestaurantsPaymentMethodPayload;

@Repository
public class RestaurantPaymentMethodRepositoryImpl implements RestaurantPaymentMethodRepository {
    private final UpdateRestaurantsPaymentMethodProducer updateRestaurantsPaymentMethodProducer;
    private final UpdateRestaurantsPaymentMethodBatchProducer updateRestaurantsPaymentMethodBatchProducer;

    public RestaurantPaymentMethodRepositoryImpl(
            UpdateRestaurantsPaymentMethodProducer updateRestaurantsPaymentMethodProducer,
            UpdateRestaurantsPaymentMethodBatchProducer updateRestaurantsPaymentMethodBatchProducer
    ) {
        this.updateRestaurantsPaymentMethodProducer = updateRestaurantsPaymentMethodProducer;
        this.updateRestaurantsPaymentMethodBatchProducer = updateRestaurantsPaymentMethodBatchProducer;
    }

    @Override
    public void updateByAreaId(String areaId, PaymentMethod paymentMethod) {
        updateRestaurantsPaymentMethodProducer.produce(
                UpdateRestaurantsPaymentMethodPayload.of(areaId, paymentMethod)
        );
    }

    @Override
    public void updateByRestaurantIds(List<String> restaurantIds, PaymentMethod paymentMethod) {
        updateRestaurantsPaymentMethodBatchProducer.produce(
                UpdateRestaurantsPaymentMethodBatchPayload.of(restaurantIds, paymentMethod)
        );
    }
}
