package com.example.demo.domain.usecase.dto.input;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetAreasInput {
    private int page;
    private int size;
}
