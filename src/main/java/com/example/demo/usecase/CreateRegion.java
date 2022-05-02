package com.example.demo.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.common.factory.RegionFactory;
import com.example.demo.domain.entity.Region;
import com.example.demo.domain.repository.RegionRepository;
import com.example.demo.usecase.dto.input.CreateRegionInput;

@Service
public class CreateRegion {
    private final RegionRepository repository;

    public CreateRegion(RegionRepository repository) {
        this.repository = repository;
    }

    public Region execute(CreateRegionInput input) {
        return repository.save(RegionFactory.of(input));
    }
}
