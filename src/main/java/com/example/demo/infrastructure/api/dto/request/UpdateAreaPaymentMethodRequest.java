package com.example.demo.infrastructure.api.dto.request;

import javax.validation.constraints.NotNull;

import com.example.demo.domain.entity.PaymentMethodType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAreaPaymentMethodRequest {
    @NotNull
    private String areaId;

    @NotNull
    private PaymentMethodType type;

    @NotNull
    private Boolean status;

    @NotNull
    private String reason;
}
