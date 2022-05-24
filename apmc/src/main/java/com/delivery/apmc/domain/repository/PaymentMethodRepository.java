package com.delivery.apmc.domain.repository;

import com.delivery.apmc.domain.entity.PaymentMethod;

public interface PaymentMethodRepository {
    void update(String areaId, PaymentMethod paymentMethod);
}
