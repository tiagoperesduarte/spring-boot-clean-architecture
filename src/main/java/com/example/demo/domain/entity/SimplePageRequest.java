package com.example.demo.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SimplePageRequest {
    private int page;
    private int size;
}
