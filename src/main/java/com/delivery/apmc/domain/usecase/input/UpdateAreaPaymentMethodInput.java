package com.delivery.apmc.domain.usecase.input;

import com.delivery.apmc.domain.entity.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateAreaPaymentMethodInput {
    private final String areaId;
    private final PaymentMethod paymentMethod;
}
