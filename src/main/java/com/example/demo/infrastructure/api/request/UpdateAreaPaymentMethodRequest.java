package com.example.demo.infrastructure.api.request;

import javax.validation.constraints.NotNull;

import com.example.demo.domain.entity.PaymentMethod;
import com.example.demo.domain.entity.PaymentMethodReason;
import com.example.demo.domain.entity.PaymentMethodType;
import com.example.demo.domain.usecase.input.UpdateAreaPaymentMethodInput;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UpdateAreaPaymentMethodRequest {
    @Setter
    private String areaId;

    @Setter
    private PaymentMethodType type;

    @NotNull
    private Boolean status;

    public UpdateAreaPaymentMethodInput toInput() {
        var paymentMethod = PaymentMethod.builder()
                                         .type(type)
                                         .status(status)
                                         .reason(PaymentMethodReason.MANUAL)
                                         .build();

        return new UpdateAreaPaymentMethodInput(areaId, paymentMethod);
    }
}
