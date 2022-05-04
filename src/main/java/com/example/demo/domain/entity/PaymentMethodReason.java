package com.example.demo.domain.entity;

public enum PaymentMethodReason {
    FRAUD(1),
    MANUAL(2),
    SATURATION(3);

    private final int priority;

    PaymentMethodReason(int priority) {
        this.priority = priority;
    }
}
