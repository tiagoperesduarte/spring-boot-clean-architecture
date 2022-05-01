package com.example.demo.application.usecase.dto.input;

import com.example.demo.domain.entity.RegionType;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateRegionInput {
    private String name;
    private RegionType type;
}
