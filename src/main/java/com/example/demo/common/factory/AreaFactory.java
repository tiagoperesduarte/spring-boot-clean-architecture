package com.example.demo.common.factory;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.common.utils.CollectionUtils;
import com.example.demo.domain.entity.Area;
import com.example.demo.domain.entity.PaymentMethod;
import com.example.demo.domain.usecase.dto.input.CreateAreaInput;
import com.example.demo.infrastructure.storage.document.AreaDocument;

public class AreaFactory {
    public static Area of(CreateAreaInput input) {
        return Area.builder()
                   .name(input.getName())
                   .type(input.getType())
                   .build();
    }

    public static Area of(AreaDocument document) {
        List<PaymentMethod> paymentMethods = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(document.getPaymentMethods())) {
            paymentMethods = document.getPaymentMethods();
        }

        return Area.builder()
                   .id(document.getId())
                   .name(document.getName())
                   .type(document.getType())
                   .paymentMethods(paymentMethods)
                   .build();
    }
}
