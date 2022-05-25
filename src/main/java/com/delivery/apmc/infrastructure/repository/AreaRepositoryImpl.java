package com.delivery.apmc.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.delivery.apmc.domain.entity.Area;
import com.delivery.apmc.domain.entity.SimplePage;
import com.delivery.apmc.domain.entity.SimplePageRequest;
import com.delivery.apmc.domain.repository.AreaRepository;
import com.delivery.apmc.infrastructure.storage.document.AreaDocument;
import com.delivery.apmc.infrastructure.storage.repository.AreaMongoRepository;

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
