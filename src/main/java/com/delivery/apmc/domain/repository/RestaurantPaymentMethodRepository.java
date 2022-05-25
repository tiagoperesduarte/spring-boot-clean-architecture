package com.delivery.apmc.domain.repository;

import com.delivery.apmc.domain.entity.PaymentMethod;

public interface RestaurantPaymentMethodRepository {
    void updateByRestaurantId(String restaurantId, PaymentMethod paymentMethod);

    void updateByAreaId(String areaId, PaymentMethod paymentMethod);
}
