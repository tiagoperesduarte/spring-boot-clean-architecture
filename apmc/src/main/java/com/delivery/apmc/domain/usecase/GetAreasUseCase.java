package com.delivery.apmc.domain.usecase;

import org.springframework.stereotype.Service;

import com.delivery.apmc.domain.entity.Area;
import com.delivery.apmc.domain.entity.SimplePage;
import com.delivery.apmc.domain.repository.AreaRepository;
import com.delivery.apmc.domain.usecase.input.GetAreasInput;

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
