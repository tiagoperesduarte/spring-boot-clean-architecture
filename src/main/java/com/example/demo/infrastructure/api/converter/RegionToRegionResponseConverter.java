package com.example.demo.infrastructure.api.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.domain.entity.Region;
import com.example.demo.infrastructure.api.dto.response.RegionResponse;

@Component
public class RegionToRegionResponseConverter implements Converter<Region, RegionResponse> {
    @Override
    public RegionResponse convert(Region region) {
        return RegionResponse.builder()
                             .id(region.getId())
                             .name(region.getName())
                             .paymentMethods(region.getPaymentMethods())
                             .build();
    }
}
