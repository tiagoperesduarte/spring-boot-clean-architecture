package com.example.demo.core.factory;

import org.springframework.data.domain.Pageable;

import com.example.demo.domain.usecase.dto.input.GetAreasInput;

public class GetAreasInputFactory {
    public static GetAreasInput of(Pageable pageable) {
        return GetAreasInput.builder()
                            .page(pageable.getPageNumber())
                            .size(pageable.getPageSize())
                            .build();
    }
}
