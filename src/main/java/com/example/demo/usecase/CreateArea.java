package com.example.demo.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.common.factory.AreaFactory;
import com.example.demo.domain.entity.Area;
import com.example.demo.domain.repository.AreaRepository;
import com.example.demo.usecase.dto.input.CreateAreaInput;

@Service
public class CreateArea {
    private final AreaRepository repository;

    public CreateArea(AreaRepository repository) {
        this.repository = repository;
    }

    public Area execute(CreateAreaInput input) {
        return repository.save(AreaFactory.of(input));
    }
}
