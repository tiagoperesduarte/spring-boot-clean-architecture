package com.example.demo.domain.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Area;
import com.example.demo.domain.repository.AreaRepository;

@Service
public class GetAreaById {
    private final AreaRepository repository;

    public GetAreaById(AreaRepository repository) {
        this.repository = repository;
    }

    public Optional<Area> execute(String areaId) {
        return repository.findById(areaId);
    }
}
