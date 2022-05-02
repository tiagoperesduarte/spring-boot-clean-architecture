package com.example.demo.usecase.dto.input;

import com.example.demo.domain.entity.AreaType;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateAreaInput {
    private String name;
    private AreaType type;
}
