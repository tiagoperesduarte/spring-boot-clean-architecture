package com.example.demo.infrastructure.api.dto.response;

import java.util.List;

import com.example.demo.domain.entity.PaymentMethod;
import com.example.demo.domain.entity.RegionType;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegionResponse {
    private String id;
    private String name;
    private RegionType type;
    private List<PaymentMethod> paymentMethods;
}
