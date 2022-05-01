package com.example.demo.infrastructure.api.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateRegionPaymentMethodResponse {
    private boolean status;
    private String reason;
}
