package com.delivery.apmc.domain.usecase.input;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GenerateFakeRestaurantsInput {
    private final String areaId;
    private final int quantity;
}
