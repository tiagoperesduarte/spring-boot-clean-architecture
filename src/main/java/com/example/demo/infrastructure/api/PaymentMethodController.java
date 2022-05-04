package com.example.demo.infrastructure.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.entity.PaymentMethodType;
import com.example.demo.domain.usecase.UpdateAreaPaymentMethodUseCase;
import com.example.demo.infrastructure.api.request.UpdateAreaPaymentMethodRequest;
import com.example.demo.infrastructure.api.response.AreaResponse;

@RestController
@RequestMapping(value = "/api/v1")
public class PaymentMethodController {
    private final UpdateAreaPaymentMethodUseCase updateAreaPaymentMethodUseCase;

    public PaymentMethodController(UpdateAreaPaymentMethodUseCase updateAreaPaymentMethodUseCase) {
        this.updateAreaPaymentMethodUseCase = updateAreaPaymentMethodUseCase;
    }

    @PutMapping(value = "/areas/{areaId}/payment-methods/{paymentMethodType}")
    public AreaResponse updateAreaPaymentMethod(
            @PathVariable String areaId,
            @PathVariable PaymentMethodType paymentMethodType,
            @Valid @RequestBody UpdateAreaPaymentMethodRequest request
    ) {
        request.setAreaId(areaId);
        request.setType(paymentMethodType);

        var area = updateAreaPaymentMethodUseCase.execute(request.toInput());
        return AreaResponse.of(area);
    }
}
