package com.example.demo.infrastructure.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.factory.AreaResponseFactory;
import com.example.demo.core.factory.UpdateAreaPaymentMethodInputFactory;
import com.example.demo.domain.entity.PaymentMethodType;
import com.example.demo.domain.usecase.UpdateAreaPaymentMethod;
import com.example.demo.infrastructure.api.dto.request.UpdateAreaPaymentMethodRequest;
import com.example.demo.infrastructure.api.dto.response.AreaResponse;

@RestController
@RequestMapping(value = "/api/v1")
public class PaymentMethodController {
    private final UpdateAreaPaymentMethod updateAreaPaymentMethod;

    public PaymentMethodController(UpdateAreaPaymentMethod updateAreaPaymentMethod) {
        this.updateAreaPaymentMethod = updateAreaPaymentMethod;
    }

    @PutMapping(value = "/areas/{areaId}/payment-methods/{paymentMethodType}")
    public AreaResponse updateAreaPaymentMethod(
            @PathVariable String areaId,
            @PathVariable PaymentMethodType paymentMethodType,
            @Valid @RequestBody UpdateAreaPaymentMethodRequest request
    ) {
        request.setAreaId(areaId);
        request.setType(paymentMethodType);

        var area = updateAreaPaymentMethod.execute(UpdateAreaPaymentMethodInputFactory.of(request));
        return AreaResponseFactory.of(area);
    }
}
