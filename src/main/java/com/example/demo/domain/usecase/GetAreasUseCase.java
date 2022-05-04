package com.example.demo.domain.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Area;
import com.example.demo.domain.entity.SimplePage;
import com.example.demo.domain.repository.AreaRepository;
import com.example.demo.domain.usecase.input.GetAreasInput;

@Service
public class GetAreasUseCase {
    private final AreaRepository areaRepository;

    public GetAreasUseCase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public SimplePage<Area> execute(GetAreasInput input) {
        return areaRepository.findAll(input.toEntity());
    }
}
