package com.example.demo.usecase.dto.input;

import com.example.demo.domain.entity.PaymentMethod;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateAreaPaymentMethodInput {
    private String areaId;
    private PaymentMethod paymentMethod;
    private String reason;
}
