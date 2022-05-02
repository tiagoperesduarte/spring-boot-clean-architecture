package com.example.demo.shared.factory;

import com.example.demo.application.usecase.dto.input.UpdateRegionPaymentMethodInput;
import com.example.demo.infrastructure.api.dto.request.UpdateRegionPaymentMethodRequest;

public class UpdateRegionPaymentMethodInputFactory {
    public static UpdateRegionPaymentMethodInput of(UpdateRegionPaymentMethodRequest request) {
        return UpdateRegionPaymentMethodInput.builder()
                                             .regionId(request.getRegionId())
                                             .paymentMethod(PaymentMethodFactory.of(request))
                                             .reason(request.getReason())
                                             .build();
    }
}
