package com.example.demo.infrastructure.producer.payload;

import java.io.Serializable;

import com.example.demo.domain.entity.PaymentMethodReason;
import com.example.demo.domain.entity.PaymentMethodType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
public class UpdateRestaurantPaymentMethodPayload implements Serializable {
    private String restaurantId;
    private PaymentMethodType type;
    private Boolean status;
    private PaymentMethodReason reason;

    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
