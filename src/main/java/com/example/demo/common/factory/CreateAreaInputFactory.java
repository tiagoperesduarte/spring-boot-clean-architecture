package com.example.demo.common.factory;

import com.example.demo.domain.usecase.dto.input.CreateAreaInput;
import com.example.demo.infrastructure.api.dto.request.CreateAreaRequest;

public class CreateAreaInputFactory {
    public static CreateAreaInput of(CreateAreaRequest request) {
        return CreateAreaInput.builder()
                              .name(request.getName())
                              .type(request.getType())
                              .build();
    }
}
