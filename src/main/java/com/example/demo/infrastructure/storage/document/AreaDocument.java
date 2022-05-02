package com.example.demo.infrastructure.storage.document;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
}
