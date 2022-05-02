package com.example.demo.infrastructure.api.dto.response;

import java.util.List;

import com.example.demo.domain.entity.AreaType;
import com.example.demo.domain.entity.PaymentMethod;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AreaResponse {
    private String id;
    private String name;
    private AreaType type;
    private List<PaymentMethod> paymentMethods;
}
