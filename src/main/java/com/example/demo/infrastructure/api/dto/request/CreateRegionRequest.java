package com.example.demo.infrastructure.api.dto.request;

import com.example.demo.domain.entity.RegionType;

import lombok.Getter;

@Getter
public class CreateRegionRequest {
    private String name;
    private RegionType type;
}
