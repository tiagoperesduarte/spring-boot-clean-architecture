package com.example.demo.domain.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.domain.entity.Area;

public interface AreaRepository {
    Page<Area> findAll(Pageable pageable);

    Optional<Area> findById(String id);

    Area save(Area area);

    void deleteById(String id);
}
