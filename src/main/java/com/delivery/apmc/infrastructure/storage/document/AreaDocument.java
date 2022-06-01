package com.delivery.apmc.infrastructure.storage.document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.delivery.apmc.core.utils.CollectionUtils;
import com.delivery.apmc.domain.entity.Area;
import com.delivery.apmc.domain.entity.AreaType;
import com.delivery.apmc.domain.entity.PaymentMethod;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection = "areas")
public class AreaDocument {
    @Id
    private String id;

    private String name;
    private AreaType type;
    private List<PaymentMethodDocument> paymentMethods;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public static AreaDocument of(Area area) {
        String id = null;

        if (area.getId() != null) {
            id = area.getId();
        }

        List<PaymentMethodDocument> paymentMethodDocuments = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(area.getPaymentMethods())) {
            paymentMethodDocuments = area.getPaymentMethods()
                                         .stream()
                                         .map(PaymentMethodDocument::of)
                                         .collect(Collectors.toList());
        }

        return AreaDocument.builder()
                           .id(id)
                           .name(area.getName())
                           .type(area.getType())
                           .paymentMethods(paymentMethodDocuments)
                           .createdOn(LocalDateTime.now())
                           .updatedOn(LocalDateTime.now())
                           .build();
    }

    public Area toEntity() {
        List<PaymentMethod> paymentMethods = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(this.paymentMethods)) {
            paymentMethods = this.paymentMethods
                    .stream()
                    .map(PaymentMethodDocument::toEntity)
                    .collect(Collectors.toList());
        }

        return Area.builder()
                   .id(id)
                   .name(name)
                   .type(type)
                   .paymentMethods(paymentMethods)
                   .build();
    }
}
