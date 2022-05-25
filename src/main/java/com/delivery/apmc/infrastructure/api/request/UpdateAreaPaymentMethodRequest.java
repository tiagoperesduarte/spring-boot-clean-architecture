package com.delivery.apmc.infrastructure.api.request;

import javax.validation.constraints.NotNull;

import com.delivery.apmc.domain.entity.PaymentMethod;
import com.delivery.apmc.domain.entity.PaymentMethodReason;
import com.delivery.apmc.domain.entity.PaymentMethodType;
import com.delivery.apmc.domain.usecase.input.UpdateAreaPaymentMethodInput;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
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
