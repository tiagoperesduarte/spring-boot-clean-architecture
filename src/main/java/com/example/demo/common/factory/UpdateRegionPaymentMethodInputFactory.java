package com.example.demo.common.factory;

import com.example.demo.infrastructure.api.dto.request.UpdateRegionPaymentMethodRequest;
import com.example.demo.usecase.dto.input.UpdateRegionPaymentMethodInput;

public class UpdateRegionPaymentMethodInputFactory {
    public static UpdateRegionPaymentMethodInput of(UpdateRegionPaymentMethodRequest request) {
        return UpdateRegionPaymentMethodInput.builder()
                                             .regionId(request.getRegionId())
                                             .paymentMethod(PaymentMethodFactory.of(request))
                                             .reason(request.getReason())
                                             .build();
    }
}
