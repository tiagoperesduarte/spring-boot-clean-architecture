package com.example.demo.infrastructure.api.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.application.usecase.dto.input.CreateRegionInput;
import com.example.demo.infrastructure.api.dto.request.CreateRegionRequest;

@Component
public class CreateRegionRequestToCreateRegionInputConverter implements Converter<CreateRegionRequest, CreateRegionInput> {
    @Override
    public CreateRegionInput convert(CreateRegionRequest request) {
        return CreateRegionInput.builder()
                                .name(request.getName())
                                .type(request.getType())
                                .build();
    }
}
