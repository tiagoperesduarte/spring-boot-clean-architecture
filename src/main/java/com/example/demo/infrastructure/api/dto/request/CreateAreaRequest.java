package com.example.demo.infrastructure.api.dto.request;

import javax.validation.constraints.NotNull;

import com.example.demo.domain.entity.AreaType;

import lombok.Getter;

@Getter
public class CreateAreaRequest {
    @NotNull
    private String name;

    @NotNull
    private AreaType type;
}
