package com.example.demo.core.factory;

import com.example.demo.domain.entity.SimplePageRequest;
import com.example.demo.domain.usecase.dto.input.GetAreasInput;

public class SimplePageRequestFactory {
    public static SimplePageRequest of(GetAreasInput input) {
        return SimplePageRequest.builder()
                                .page(input.getPage())
                                .size(input.getSize())
                                .build();
    }
}
