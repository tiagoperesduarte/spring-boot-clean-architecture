package com.example.demo.infrastructure.storage.repository.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.demo.core.factory.AreaDocumentFactory;
import com.example.demo.core.factory.AreaFactory;
import com.example.demo.domain.entity.Area;
import com.example.demo.domain.repository.AreaRepository;
import com.example.demo.infrastructure.storage.repository.AreaMongoRepository;

@Repository
public class AreaRepositoryImpl implements AreaRepository {
    private final AreaMongoRepository repository;

    public AreaRepositoryImpl(AreaMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Area> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                         .map(AreaFactory::of);
    }

    @Override
    public Optional<Area> findById(String id) {
        return repository.findById(id)
                         .map(AreaFactory::of);
    }

    @Override
    public Area save(Area area) {
        var savedAreaDocument = repository.save(AreaDocumentFactory.of(area));
        return AreaFactory.of(savedAreaDocument);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
