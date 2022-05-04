package com.example.demo.infrastructure.api.response;

import java.util.List;

import com.example.demo.domain.entity.Area;
import com.example.demo.domain.entity.AreaType;
import com.example.demo.domain.entity.PaymentMethod;

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
