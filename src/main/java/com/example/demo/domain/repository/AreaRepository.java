package com.example.demo.domain.repository;

import java.util.Optional;

import com.example.demo.domain.entity.Area;
import com.example.demo.domain.entity.SimplePage;
import com.example.demo.domain.entity.SimplePageRequest;

public interface AreaRepository {
    SimplePage<Area> findAll(SimplePageRequest simplePageRequest);

    Optional<Area> findById(String id);

    Area save(Area area);

    void deleteById(String id);
}
