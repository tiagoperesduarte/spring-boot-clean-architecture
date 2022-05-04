package com.example.demo.infrastructure.storage.document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.core.utils.CollectionUtils;
import com.example.demo.domain.entity.Area;
import com.example.demo.domain.entity.AreaType;
import com.example.demo.domain.entity.PaymentMethod;

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
    private List<PaymentMethod> paymentMethods;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

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

    public Area toEntity() {
        List<PaymentMethod> paymentMethods = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(this.paymentMethods)) {
            paymentMethods = this.paymentMethods;
        }

        return Area.builder()
                   .id(id)
                   .name(name)
                   .type(type)
                   .paymentMethods(paymentMethods)
                   .build();
    }
}
