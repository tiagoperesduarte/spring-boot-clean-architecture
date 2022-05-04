package com.example.demo.domain.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Area;
import com.example.demo.domain.repository.AreaRepository;
import com.example.demo.domain.usecase.input.CreateAreaInput;

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
