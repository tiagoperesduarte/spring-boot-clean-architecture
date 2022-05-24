package com.delivery.apmc.infrastructure.storage.document;

import com.delivery.apmc.domain.entity.PaymentMethod;
import com.delivery.apmc.domain.entity.PaymentMethodReason;
import com.delivery.apmc.domain.entity.PaymentMethodType;

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
