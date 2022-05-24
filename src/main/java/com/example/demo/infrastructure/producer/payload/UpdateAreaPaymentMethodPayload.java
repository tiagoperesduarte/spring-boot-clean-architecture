package com.example.demo.infrastructure.producer.payload;

import java.io.Serializable;

import com.example.demo.domain.entity.PaymentMethod;
import com.example.demo.domain.entity.PaymentMethodReason;
import com.example.demo.domain.entity.PaymentMethodType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UpdateAreaPaymentMethodPayload implements Serializable {
    private String areaId;
    private PaymentMethodType type;
    private Boolean status;
    private PaymentMethodReason reason;

    public static UpdateAreaPaymentMethodPayload of(String areaId, PaymentMethod paymentMethod) {
        return new UpdateAreaPaymentMethodPayload(
                areaId,
                paymentMethod.getType(),
                paymentMethod.isStatus(),
                paymentMethod.getReason()
        );
    }

    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
