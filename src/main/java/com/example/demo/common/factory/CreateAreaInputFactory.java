package com.example.demo.common.factory;

import com.example.demo.infrastructure.api.dto.request.CreateAreaRequest;
import com.example.demo.usecase.dto.input.CreateAreaInput;

public class CreateAreaInputFactory {
    public static CreateAreaInput of(CreateAreaRequest request) {
        return CreateAreaInput.builder()
                              .name(request.getName())
                              .type(request.getType())
                              .build();
    }
}
