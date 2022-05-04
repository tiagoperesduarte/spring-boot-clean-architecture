package com.example.demo.infrastructure.storage.repository.impl;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.Area;
import com.example.demo.domain.entity.SimplePage;
import com.example.demo.domain.entity.SimplePageRequest;
import com.example.demo.domain.repository.AreaRepository;
import com.example.demo.infrastructure.storage.document.AreaDocument;
import com.example.demo.infrastructure.storage.repository.AreaMongoRepository;

@Repository
public class AreaRepositoryImpl implements AreaRepository {
    private final AreaMongoRepository repository;

    public AreaRepositoryImpl(AreaMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public SimplePage<Area> findAll(SimplePageRequest simplePageRequest) {
        var pageRequest = PageRequest.of(simplePageRequest.getPage(), simplePageRequest.getSize());
        var page = repository.findAll(pageRequest)
                             .map(AreaDocument::toEntity);

        return new SimplePage<>(page.getContent(), page.getTotalElements());
    }

    @Override
    public Optional<Area> findById(String id) {
        return repository.findById(id)
                         .map(AreaDocument::toEntity);
    }

    @Override
    public Area save(Area area) {
        var savedAreaDocument = repository.save(AreaDocument.of(area));
        return savedAreaDocument.toEntity();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
