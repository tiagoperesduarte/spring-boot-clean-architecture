package com.example.demo.infrastructure.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.factory.RegionResponseFactory;
import com.example.demo.common.factory.UpdateRegionPaymentMethodInputFactory;
import com.example.demo.domain.entity.PaymentMethodType;
import com.example.demo.infrastructure.api.dto.request.UpdateRegionPaymentMethodRequest;
import com.example.demo.infrastructure.api.dto.response.RegionResponse;
import com.example.demo.usecase.UpdateRegionPaymentMethod;

@RestController
@RequestMapping(value = "/api/v1")
public class PaymentMethodController {
    private final UpdateRegionPaymentMethod updateRegionPaymentMethod;

    public PaymentMethodController(UpdateRegionPaymentMethod updateRegionPaymentMethod) {
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

        var region = updateRegionPaymentMethod.execute(UpdateRegionPaymentMethodInputFactory.of(request));
        return RegionResponseFactory.of(region);
    }
}
