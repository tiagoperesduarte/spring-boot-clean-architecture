package com.delivery.apmc.infrastructure.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.apmc.domain.entity.PaymentMethodType;
import com.delivery.apmc.domain.usecase.UpdateAreaPaymentMethodUseCase;
import com.delivery.apmc.infrastructure.api.request.UpdateAreaPaymentMethodRequest;
import com.delivery.apmc.infrastructure.api.response.AreaResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

        log.debug("Request to update area payment method with data (data={})", request);

        var area = updateAreaPaymentMethodUseCase.execute(request.toInput());
        return AreaResponse.of(area);
    }
}
