package com.example.demo.infrastructure.api.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.application.usecase.dto.input.UpdateRegionPaymentMethodInput;
import com.example.demo.domain.entity.PaymentMethod;
import com.example.demo.infrastructure.api.dto.request.UpdateRegionPaymentMethodRequest;

@Component
public class UpdateRegionPaymentMethodRequestToUpdateRegionPaymentMethodInputConverter implements Converter<UpdateRegionPaymentMethodRequest, UpdateRegionPaymentMethodInput> {
    @Override
    public UpdateRegionPaymentMethodInput convert(UpdateRegionPaymentMethodRequest request) {
        var paymentMethod = PaymentMethod.builder()
                                         .type(request.getType())
                                         .status(request.isStatus())
                                         .build();

        return UpdateRegionPaymentMethodInput.builder()
                                             .regionId(request.getRegionId())
                                             .paymentMethod(paymentMethod)
                                             .reason(request.getReason())
                                             .build();
    }
}
