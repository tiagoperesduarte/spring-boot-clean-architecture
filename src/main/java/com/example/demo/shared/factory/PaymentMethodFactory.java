package com.example.demo.shared.factory;

import com.example.demo.domain.entity.PaymentMethod;
import com.example.demo.infrastructure.api.dto.request.UpdateRegionPaymentMethodRequest;

public class PaymentMethodFactory {
    public static PaymentMethod of(UpdateRegionPaymentMethodRequest request) {
        return PaymentMethod.builder()
                            .type(request.getType())
                            .status(request.isStatus())
                            .build();
    }
}
