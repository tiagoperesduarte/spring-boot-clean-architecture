package com.example.demo.common.factory;

import com.example.demo.infrastructure.api.dto.request.UpdateAreaPaymentMethodRequest;
import com.example.demo.usecase.dto.input.UpdateAreaPaymentMethodInput;

public class UpdateAreaPaymentMethodInputFactory {
    public static UpdateAreaPaymentMethodInput of(UpdateAreaPaymentMethodRequest request) {
        return UpdateAreaPaymentMethodInput.builder()
                                           .areaId(request.getAreaId())
                                           .paymentMethod(PaymentMethodFactory.of(request))
                                           .reason(request.getReason())
                                           .build();
    }
}
