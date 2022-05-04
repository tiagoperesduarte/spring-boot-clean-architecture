package com.example.demo.domain.usecase.input;

import com.example.demo.domain.entity.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateAreaPaymentMethodInput {
    private final String areaId;
    private final PaymentMethod paymentMethod;
}
