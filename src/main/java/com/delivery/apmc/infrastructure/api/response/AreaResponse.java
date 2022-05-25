package com.delivery.apmc.infrastructure.api.response;

import java.util.List;

import com.delivery.apmc.domain.entity.Area;
import com.delivery.apmc.domain.entity.AreaType;
import com.delivery.apmc.domain.entity.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AreaResponse {
    private String id;
    private String name;
    private AreaType type;
    private List<PaymentMethod> paymentMethods;

    public static AreaResponse of(Area area) {
        return new AreaResponse(
                area.getId(),
                area.getName(),
                area.getType(),
                area.getPaymentMethods()
        );
    }
}
