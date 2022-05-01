package com.example.demo.infrastructure.api.dto.request;

import com.example.demo.domain.entity.PaymentMethodType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRegionPaymentMethodRequest {
    private String regionId;
    private PaymentMethodType type;
    private boolean status;
    private String reason;
}
