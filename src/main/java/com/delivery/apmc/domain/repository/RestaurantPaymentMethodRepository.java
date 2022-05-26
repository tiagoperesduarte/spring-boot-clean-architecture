package com.delivery.apmc.domain.repository;

import java.util.List;

import com.delivery.apmc.domain.entity.PaymentMethod;

public interface RestaurantPaymentMethodRepository {
    void updateByAreaId(String areaId, PaymentMethod paymentMethod);

    void updateByRestaurantIds(List<String> restaurantIds, PaymentMethod paymentMethod);
}
