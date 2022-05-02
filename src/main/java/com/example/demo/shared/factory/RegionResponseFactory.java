package com.example.demo.shared.factory;

import com.example.demo.domain.entity.Region;
import com.example.demo.infrastructure.api.dto.response.RegionResponse;

public class RegionResponseFactory {
    public static RegionResponse of(Region region) {
        return RegionResponse.builder()
                             .id(region.getId())
                             .name(region.getName())
                             .type(region.getType())
                             .paymentMethods(region.getPaymentMethods())
                             .build();
    }
}
