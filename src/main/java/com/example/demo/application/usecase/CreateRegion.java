package com.example.demo.application.usecase;

import java.util.Objects;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.example.demo.application.usecase.dto.input.CreateRegionInput;
import com.example.demo.domain.entity.Region;
import com.example.demo.domain.repository.RegionRepository;

@Service
public class CreateRegion {
    private final ConversionService converter;
    private final RegionRepository repository;

    public CreateRegion(
            ConversionService converter,
            RegionRepository repository
    ) {
        this.converter = converter;
        this.repository = repository;
    }

    public Region execute(CreateRegionInput input) {
        var region = Objects.requireNonNull(converter.convert(input, Region.class));
        return repository.save(region);
    }
}
