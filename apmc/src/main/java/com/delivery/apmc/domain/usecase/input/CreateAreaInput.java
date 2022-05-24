package com.delivery.apmc.domain.usecase.input;

import com.delivery.apmc.domain.entity.Area;
import com.delivery.apmc.domain.entity.AreaType;

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
