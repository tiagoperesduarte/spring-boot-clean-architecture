package com.example.demo.domain.repository;

import com.example.demo.domain.entity.PaymentMethod;

public interface PaymentMethodRepository {
    void update(String areaId, PaymentMethod paymentMethod);
}
