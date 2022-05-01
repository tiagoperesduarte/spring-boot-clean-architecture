package com.example.demo.application.usecase.dto.input;

import com.example.demo.domain.entity.PaymentMethod;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateRegionPaymentMethodInput {
    private String regionId;
    private PaymentMethod paymentMethod;
    private String reason;
}
