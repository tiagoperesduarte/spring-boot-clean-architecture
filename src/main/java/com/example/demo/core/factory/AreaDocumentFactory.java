package com.example.demo.core.factory;

import com.example.demo.domain.entity.Area;
import com.example.demo.infrastructure.storage.document.AreaDocument;

public class AreaDocumentFactory {
    public static AreaDocument of(Area area) {
        String id = null;

        if (area.getId() != null) {
            id = area.getId();
        }

        return AreaDocument.builder()
                           .id(id)
                           .name(area.getName())
                           .type(area.getType())
                           .paymentMethods(area.getPaymentMethods())
                           .build();
    }
}
