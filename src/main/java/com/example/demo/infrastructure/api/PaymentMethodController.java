package com.example.demo.infrastructure.api;

import javax.validation.Valid;

import java.util.Objects;

import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.usecase.UpdateRegionPaymentMethod;
import com.example.demo.application.usecase.dto.input.UpdateRegionPaymentMethodInput;
import com.example.demo.domain.entity.PaymentMethodType;
import com.example.demo.infrastructure.api.dto.request.UpdateRegionPaymentMethodRequest;
import com.example.demo.infrastructure.api.dto.response.RegionResponse;

@RestController
@RequestMapping(value = "/api/v1")
public class PaymentMethodController {
    private final ConversionService converter;
    private final UpdateRegionPaymentMethod updateRegionPaymentMethod;

    public PaymentMethodController(
            ConversionService converter,
            UpdateRegionPaymentMethod updateRegionPaymentMethod
    ) {
        this.converter = converter;
        this.updateRegionPaymentMethod = updateRegionPaymentMethod;
    }

    @PutMapping(value = "/regions/{regionId}/payment-methods/{paymentMethodType}")
    public RegionResponse updateRegionPaymentMethod(
            @PathVariable String regionId,
            @PathVariable PaymentMethodType paymentMethodType,
            @Valid @RequestBody UpdateRegionPaymentMethodRequest request
    ) {
        request.setRegionId(regionId);
        request.setType(paymentMethodType);

        var input = Objects.requireNonNull(converter.convert(request, UpdateRegionPaymentMethodInput.class));
        var output = updateRegionPaymentMethod.execute(input);

        return converter.convert(output, RegionResponse.class);
    }
}
