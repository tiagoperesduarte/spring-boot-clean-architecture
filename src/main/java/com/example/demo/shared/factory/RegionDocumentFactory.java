package com.example.demo.shared.factory;

import com.example.demo.domain.entity.Region;
import com.example.demo.infrastructure.storage.document.RegionDocument;

public class RegionDocumentFactory {
    public static RegionDocument of(Region region) {
        String id = null;

        if (region.getId() != null) {
            id = region.getId();
        }

        return RegionDocument.builder()
                             .id(id)
                             .name(region.getName())
                             .type(region.getType())
                             .paymentMethods(region.getPaymentMethods())
                             .build();
    }
}
