package com.example.demo.domain.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Area;
import com.example.demo.domain.exception.AreaNotFoundException;
import com.example.demo.domain.repository.AreaRepository;

@Service
public class GetAreaUseCase {
    private final AreaRepository areaRepository;

    public GetAreaUseCase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public Area execute(String areaId) {
        return areaRepository.findById(areaId)
                             .orElseThrow(() -> new AreaNotFoundException("Area not found with id " + areaId));
    }
}
