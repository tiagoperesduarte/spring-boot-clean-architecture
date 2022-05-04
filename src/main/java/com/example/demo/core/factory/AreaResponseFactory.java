package com.example.demo.core.factory;

import org.springframework.stereotype.Component;

import com.example.demo.domain.entity.Area;
import com.example.demo.infrastructure.api.dto.response.AreaResponse;

@Component
public class AreaResponseFactory {
    public static AreaResponse of(Area area) {
        return AreaResponse.builder()
                           .id(area.getId())
                           .name(area.getName())
                           .type(area.getType())
                           .paymentMethods(area.getPaymentMethods())
                           .build();
    }
}
