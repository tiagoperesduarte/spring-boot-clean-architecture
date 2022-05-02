package com.example.demo.common.factory;

import com.example.demo.infrastructure.api.dto.request.CreateRegionRequest;
import com.example.demo.usecase.dto.input.CreateRegionInput;

public class CreateRegionInputFactory {
    public static CreateRegionInput of(CreateRegionRequest request) {
        return CreateRegionInput.builder()
                                .name(request.getName())
                                .type(request.getType())
                                .build();
    }
}
