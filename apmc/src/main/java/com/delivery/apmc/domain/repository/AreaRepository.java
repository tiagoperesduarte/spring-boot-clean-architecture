package com.delivery.apmc.domain.repository;

import java.util.Optional;

import com.delivery.apmc.domain.entity.Area;
import com.delivery.apmc.domain.entity.SimplePage;
import com.delivery.apmc.domain.entity.SimplePageRequest;

public interface AreaRepository {
    SimplePage<Area> findAll(SimplePageRequest simplePageRequest);

    Optional<Area> findById(String id);

    Area save(Area area);

    void deleteById(String id);
}
