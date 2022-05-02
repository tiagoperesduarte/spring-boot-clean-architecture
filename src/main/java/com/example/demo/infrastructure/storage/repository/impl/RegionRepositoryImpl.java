package com.example.demo.infrastructure.storage.repository.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.demo.common.factory.RegionDocumentFactory;
import com.example.demo.common.factory.RegionFactory;
import com.example.demo.domain.entity.Region;
import com.example.demo.domain.repository.RegionRepository;
import com.example.demo.infrastructure.storage.repository.RegionMongoRepository;

@Repository
public class RegionRepositoryImpl implements RegionRepository {
    private final RegionMongoRepository repository;

    public RegionRepositoryImpl(RegionMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Region> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                         .map(RegionFactory::of);
    }

    @Override
    public Optional<Region> findById(String id) {
        return repository.findById(id)
                         .map(RegionFactory::of);
    }

    @Override
    public Region save(Region region) {
        var savedRegionDocument = repository.save(RegionDocumentFactory.of(region));
        return RegionFactory.of(savedRegionDocument);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
