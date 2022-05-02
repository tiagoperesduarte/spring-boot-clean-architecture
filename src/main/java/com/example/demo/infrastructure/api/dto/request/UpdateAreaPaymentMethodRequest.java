package com.example.demo.infrastructure.api.dto.request;

import com.example.demo.domain.entity.PaymentMethodType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAreaPaymentMethodRequest {
    private String areaId;
    private PaymentMethodType type;
    private boolean status;
    private String reason;
}
