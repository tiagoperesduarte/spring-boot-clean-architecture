package com.example.demo.infrastructure.storage.repository.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.Region;
import com.example.demo.domain.repository.RegionRepository;
import com.example.demo.infrastructure.storage.document.RegionDocument;
import com.example.demo.infrastructure.storage.repository.RegionMongoRepository;

@Repository
public class RegionRepositoryImpl implements RegionRepository {
    private final ConversionService converter;
    private final RegionMongoRepository repository;

    public RegionRepositoryImpl(
            final ConversionService converter,
            final RegionMongoRepository repository
    ) {
        this.converter = converter;
        this.repository = repository;
    }

    @Override
    public Page<Region> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                         .map(document -> converter.convert(document, Region.class));
    }

    @Override
    public Optional<Region> findById(String id) {
        return repository.findById(id)
                         .map(document -> converter.convert(document, Region.class));
    }

    @Override
    public Region save(Region region) {
        var regionDocument = Objects.requireNonNull(converter.convert(region, RegionDocument.class));
        var savedRegionDocument = repository.save(regionDocument);

        return converter.convert(savedRegionDocument, Region.class);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
