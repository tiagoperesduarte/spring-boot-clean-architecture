package com.delivery.apmc.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SimplePageRequest {
    private int page;
    private int size;
}
