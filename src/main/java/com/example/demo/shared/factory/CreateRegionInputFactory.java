package com.example.demo.shared.factory;

import com.example.demo.application.usecase.dto.input.CreateRegionInput;
import com.example.demo.infrastructure.api.dto.request.CreateRegionRequest;

public class CreateRegionInputFactory {
    public static CreateRegionInput of(CreateRegionRequest request) {
        return CreateRegionInput.builder()
                                .name(request.getName())
                                .type(request.getType())
                                .build();
    }
}
