package com.example.demo.infrastructure.storage.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.domain.entity.Region;
import com.example.demo.infrastructure.storage.document.RegionDocument;

@Component
public class RegionToRegionDocumentConverter implements Converter<Region, RegionDocument> {
    @Override
    public RegionDocument convert(Region region) {
        String id = null;

        if (region.getId() != null) {
            id = region.getId();
        }

        return RegionDocument.builder()
                             .id(id)
                             .name(region.getName())
                             .paymentMethods(region.getPaymentMethods())
                             .build();
    }
}
