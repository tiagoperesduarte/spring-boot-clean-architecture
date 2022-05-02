package com.example.demo.infrastructure.api.dto.request;

import com.example.demo.domain.entity.AreaType;

import lombok.Getter;

@Getter
public class CreateAreaRequest {
    private String name;
    private AreaType type;
}
