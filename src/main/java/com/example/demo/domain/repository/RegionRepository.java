package com.example.demo.domain.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.domain.entity.Region;

public interface RegionRepository {
    Page<Region> findAll(Pageable pageable);

    Optional<Region> findById(String id);

    Region save(Region region);

    void deleteById(String id);
}
