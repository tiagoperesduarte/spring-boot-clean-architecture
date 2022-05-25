package com.delivery.apmc.domain.entity;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Restaurant {
    private String id;
    private String name;
    private List<String> areaIds;
}
