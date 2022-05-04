package com.example.demo.domain.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.core.factory.SimplePageRequestFactory;
import com.example.demo.domain.entity.Area;
import com.example.demo.domain.entity.SimplePage;
import com.example.demo.domain.repository.AreaRepository;
import com.example.demo.domain.usecase.dto.input.GetAreasInput;

@Service
public class GetAreas {
    private final AreaRepository areaRepository;

    public GetAreas(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public SimplePage<Area> execute(GetAreasInput input) {
        return areaRepository.findAll(SimplePageRequestFactory.of(input));
    }
}
