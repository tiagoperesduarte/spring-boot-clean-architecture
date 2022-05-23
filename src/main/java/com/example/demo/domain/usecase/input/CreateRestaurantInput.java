package com.example.demo.domain.usecase.input;

import java.util.List;

import com.example.demo.domain.entity.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateRestaurantInput {
    private final String name;
    private final List<String> areaIds;

    public Restaurant toEntity() {
        return Restaurant.builder()
                         .name(name)
                         .areaIds(areaIds)
                         .build();
    }
}
