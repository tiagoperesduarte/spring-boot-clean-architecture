package com.example.demo.infrastructure.storage.document;

import com.example.demo.domain.entity.PaymentMethod;
import com.example.demo.domain.entity.PaymentMethodReason;
import com.example.demo.domain.entity.PaymentMethodType;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class PaymentMethodDocument {
    private PaymentMethodType type;
    private boolean status;
    private PaymentMethodReason reason;

    public static PaymentMethodDocument of(PaymentMethod paymentMethod) {
        return PaymentMethodDocument.builder()
                                    .type(paymentMethod.getType())
                                    .status(paymentMethod.isStatus())
                                    .reason(paymentMethod.getReason())
                                    .build();
    }

    public PaymentMethod toEntity() {
        return PaymentMethod.builder()
                            .type(type)
                            .status(status)
                            .reason(reason)
                            .build();
    }
}
