package com.delivery.apmc.infrastructure.api.request;

import javax.validation.constraints.NotNull;

import com.delivery.apmc.domain.usecase.input.GenerateFakeRestaurantsInput;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GenerateFakeRestaurantsRequest {
    @NotNull
    private String areaId;

    @NotNull
    private Integer quantity;

    public GenerateFakeRestaurantsInput toInput() {
        return new GenerateFakeRestaurantsInput(areaId, quantity);
    }
}
