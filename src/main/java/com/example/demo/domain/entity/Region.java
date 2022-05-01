package com.example.demo.domain.entity;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Region {
    private String id;
    private String name;
    private RegionType type;
    private List<PaymentMethod> paymentMethods;

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.add(paymentMethod);
    }
}
