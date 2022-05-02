package com.example.demo.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Region;
import com.example.demo.domain.repository.RegionRepository;

@Service
public class GetRegions {
    private final RegionRepository repository;

    public GetRegions(RegionRepository repository) {
        this.repository = repository;
    }

    public Page<Region> execute(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
