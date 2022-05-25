package com.delivery.apmc.infrastructure.event.producer.payload;

import java.io.Serializable;

import com.delivery.apmc.domain.entity.PaymentMethod;
import com.delivery.apmc.domain.entity.PaymentMethodReason;
import com.delivery.apmc.domain.entity.PaymentMethodType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UpdateRestaurantPaymentMethodPayload implements Serializable {
    private String restaurantId;
    private PaymentMethodType type;
    private Boolean status;
    private PaymentMethodReason reason;

    public static UpdateRestaurantPaymentMethodPayload of(String restaurantId, PaymentMethod paymentMethod) {
        return new UpdateRestaurantPaymentMethodPayload(
                restaurantId,
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
