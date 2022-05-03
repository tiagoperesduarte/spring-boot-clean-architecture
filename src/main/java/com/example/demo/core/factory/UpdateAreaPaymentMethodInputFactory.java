package com.example.demo.core.factory;

import com.example.demo.domain.usecase.dto.input.UpdateAreaPaymentMethodInput;
import com.example.demo.infrastructure.api.dto.request.UpdateAreaPaymentMethodRequest;

public class UpdateAreaPaymentMethodInputFactory {
    public static UpdateAreaPaymentMethodInput of(UpdateAreaPaymentMethodRequest request) {
        return UpdateAreaPaymentMethodInput.builder()
                                           .areaId(request.getAreaId())
                                           .paymentMethod(PaymentMethodFactory.of(request))
                                           .reason(request.getReason())
                                           .build();
    }
}
