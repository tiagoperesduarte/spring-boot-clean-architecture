package com.example.demo.infrastructure.consumer.payload;

import java.io.Serializable;

import com.example.demo.domain.entity.PaymentMethod;
import com.example.demo.domain.entity.PaymentMethodReason;
import com.example.demo.domain.entity.PaymentMethodType;
import com.example.demo.domain.usecase.input.UpdateAreaPaymentMethodInput;

import lombok.Data;

@Data
public class UpdateAreaPaymentMethodPayload implements Serializable {
    private String areaId;
    private PaymentMethodType type;
    private Boolean status;
    private PaymentMethodReason reason;

    public UpdateAreaPaymentMethodInput toInput() {
        var paymentMethod = PaymentMethod.builder()
                                         .type(type)
                                         .status(status)
                                         .reason(reason)
                                         .build();

        return new UpdateAreaPaymentMethodInput(areaId, paymentMethod);
    }
}
