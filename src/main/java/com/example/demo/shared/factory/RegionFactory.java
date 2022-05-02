package com.example.demo.shared.factory;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.application.usecase.dto.input.CreateRegionInput;
import com.example.demo.domain.entity.PaymentMethod;
import com.example.demo.domain.entity.Region;
import com.example.demo.infrastructure.storage.document.RegionDocument;
import com.example.demo.shared.utils.CollectionUtils;

public class RegionFactory {
    public static Region of(CreateRegionInput input) {
        return Region.builder()
                     .name(input.getName())
                     .type(input.getType())
                     .build();
    }

    public static Region of(RegionDocument document) {
        List<PaymentMethod> paymentMethods = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(document.getPaymentMethods())) {
            paymentMethods = document.getPaymentMethods();
        }

        return Region.builder()
                     .id(document.getId())
                     .name(document.getName())
                     .type(document.getType())
                     .paymentMethods(paymentMethods)
                     .build();
    }
}
