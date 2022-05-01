package com.example.demo.infrastructure.storage.document;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.domain.entity.PaymentMethod;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection = "regions")
public class RegionDocument {
    @Id
    private String id;

    private String name;
    private List<PaymentMethod> paymentMethods;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
