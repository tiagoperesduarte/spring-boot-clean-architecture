package com.example.demo.common.factory;

import com.example.demo.domain.entity.PaymentMethod;
import com.example.demo.infrastructure.api.dto.request.UpdateAreaPaymentMethodRequest;

public class PaymentMethodFactory {
    public static PaymentMethod of(UpdateAreaPaymentMethodRequest request) {
        return PaymentMethod.builder()
                            .type(request.getType())
                            .status(request.isStatus())
                            .build();
    }
}
