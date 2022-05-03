package com.example.demo.domain.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.core.factory.AreaFactory;
import com.example.demo.domain.entity.Area;
import com.example.demo.domain.repository.AreaRepository;
import com.example.demo.domain.usecase.dto.input.CreateAreaInput;

@Service
public class CreateArea {
    private final AreaRepository areaRepository;

    public CreateArea(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public Area execute(CreateAreaInput input) {
        return areaRepository.save(AreaFactory.of(input));
    }
}
