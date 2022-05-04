package com.example.demo.infrastructure.storage.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.core.factory.AreaDocumentFactory;
import com.example.demo.core.factory.AreaFactory;
import com.example.demo.core.factory.PageRequestFactory;
import com.example.demo.core.factory.SimplePageFactory;
import com.example.demo.domain.entity.Area;
import com.example.demo.domain.entity.SimplePage;
import com.example.demo.domain.entity.SimplePageRequest;
import com.example.demo.domain.repository.AreaRepository;
import com.example.demo.infrastructure.storage.repository.AreaMongoRepository;

@Repository
public class AreaRepositoryImpl implements AreaRepository {
    private final AreaMongoRepository repository;

    public AreaRepositoryImpl(AreaMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public SimplePage<Area> findAll(SimplePageRequest simplePageRequest) {
        var page = repository.findAll(PageRequestFactory.of(simplePageRequest))
                             .map(AreaFactory::of);

        return SimplePageFactory.of(page);
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
