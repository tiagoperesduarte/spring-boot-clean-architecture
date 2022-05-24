package com.example.demo.infrastructure.storage.repository;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.Area;
import com.example.demo.domain.entity.SimplePage;
import com.example.demo.domain.entity.SimplePageRequest;
import com.example.demo.domain.repository.AreaRepository;
import com.example.demo.infrastructure.storage.document.AreaDocument;

@Repository
public class AreaRepositoryImpl implements AreaRepository {
    private final AreaMongoRepository areaMongoRepository;

    public AreaRepositoryImpl(AreaMongoRepository areaMongoRepository) {
        this.areaMongoRepository = areaMongoRepository;
    }

    @Override
    public SimplePage<Area> findAll(SimplePageRequest simplePageRequest) {
        var pageRequest = PageRequest.of(simplePageRequest.getPage(), simplePageRequest.getSize());
        var page = areaMongoRepository.findAll(pageRequest)
                                      .map(AreaDocument::toEntity);

        return new SimplePage<>(page.getContent(), page.getTotalElements());
    }

    @Override
    public Optional<Area> findById(String id) {
        return areaMongoRepository.findById(id)
                                  .map(AreaDocument::toEntity);
    }

    @Override
    public Area save(Area area) {
        var savedAreaDocument = areaMongoRepository.save(AreaDocument.of(area));
        return savedAreaDocument.toEntity();
    }

    @Override
    public void deleteById(String id) {
        areaMongoRepository.deleteById(id);
    }
}
