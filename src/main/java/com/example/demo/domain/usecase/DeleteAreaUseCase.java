package com.example.demo.domain.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.domain.repository.AreaRepository;

@Service
public class DeleteAreaUseCase {
    private final AreaRepository areaRepository;

    public DeleteAreaUseCase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public void execute(String areaId) {
        areaRepository.deleteById(areaId);
    }
}
