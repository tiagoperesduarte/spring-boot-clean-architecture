package com.example.demo.domain.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Area;
import com.example.demo.domain.repository.AreaRepository;

@Service
public class GetAreas {
    private final AreaRepository areaRepository;

    public GetAreas(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public Page<Area> execute(Pageable pageable) {
        return areaRepository.findAll(pageable);
    }
}
