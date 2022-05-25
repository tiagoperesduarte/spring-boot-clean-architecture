package com.delivery.apmc.infrastructure.event.consumer.payload;

import java.io.Serializable;

import com.delivery.apmc.domain.entity.PaymentMethod;
import com.delivery.apmc.domain.entity.PaymentMethodReason;
import com.delivery.apmc.domain.entity.PaymentMethodType;
import com.delivery.apmc.domain.usecase.input.UpdateRestaurantsPaymentMethodInput;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UpdateRestaurantsPaymentMethodPayload implements Serializable {
    private String areaId;
    private PaymentMethodType type;
    private Boolean status;
    private PaymentMethodReason reason;

    public UpdateRestaurantsPaymentMethodInput toInput() {
        var paymentMethod = PaymentMethod.builder()
                                         .type(type)
                                         .status(status)
                                         .reason(reason)
                                         .build();

        return new UpdateRestaurantsPaymentMethodInput(areaId, paymentMethod);
    }
}
