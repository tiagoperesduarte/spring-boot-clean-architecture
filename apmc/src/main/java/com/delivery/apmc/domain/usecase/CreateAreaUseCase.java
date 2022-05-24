package com.delivery.apmc.domain.usecase;

import org.springframework.stereotype.Service;

import com.delivery.apmc.domain.entity.Area;
import com.delivery.apmc.domain.repository.AreaRepository;
import com.delivery.apmc.domain.usecase.input.CreateAreaInput;

@Service
public class CreateAreaUseCase {
    private final AreaRepository areaRepository;

    public CreateAreaUseCase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public Area execute(CreateAreaInput input) {
        return areaRepository.save(input.toEntity());
    }
}
