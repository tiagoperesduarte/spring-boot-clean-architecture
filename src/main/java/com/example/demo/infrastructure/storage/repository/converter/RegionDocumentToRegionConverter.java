package com.example.demo.infrastructure.storage.repository.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.domain.entity.PaymentMethod;
import com.example.demo.domain.entity.Region;
import com.example.demo.infrastructure.storage.document.RegionDocument;
import com.example.demo.utils.CollectionUtils;

@Component
public class RegionDocumentToRegionConverter implements Converter<RegionDocument, Region> {
    @Override
    public Region convert(RegionDocument document) {
        List<PaymentMethod> paymentMethods = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(document.getPaymentMethods())) {
            paymentMethods = document.getPaymentMethods();
        }

        return Region.builder()
                     .id(document.getId())
                     .name(document.getName())
                     .paymentMethods(paymentMethods)
                     .build();
    }
}
