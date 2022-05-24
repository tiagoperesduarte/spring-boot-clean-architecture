package com.delivery.apmc.domain.usecase;

import org.springframework.stereotype.Service;

import com.delivery.apmc.domain.entity.Area;
import com.delivery.apmc.domain.exception.AreaNotFoundException;
import com.delivery.apmc.domain.repository.AreaRepository;

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
