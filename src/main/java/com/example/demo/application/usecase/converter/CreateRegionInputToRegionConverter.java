package com.example.demo.application.usecase.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.application.usecase.dto.input.CreateRegionInput;
import com.example.demo.domain.entity.Region;

@Component
public class CreateRegionInputToRegionConverter implements Converter<CreateRegionInput, Region> {
    @Override
    public Region convert(CreateRegionInput input) {
        return Region.builder()
                     .name(input.getName())
                     .type(input.getType())
                     .build();
    }
}
