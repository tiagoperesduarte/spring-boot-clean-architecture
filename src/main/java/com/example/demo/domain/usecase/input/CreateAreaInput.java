package com.example.demo.domain.usecase.input;

import com.example.demo.domain.entity.Area;
import com.example.demo.domain.entity.AreaType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateAreaInput {
    private final String name;
    private final AreaType type;

    public Area toEntity() {
        return Area.builder()
                   .name(name)
                   .type(type)
                   .build();
    }
}
