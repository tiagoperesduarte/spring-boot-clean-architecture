package com.delivery.apmc.infrastructure.api.request;

import javax.validation.constraints.NotNull;

import java.util.List;

import com.delivery.apmc.domain.usecase.input.CreateRestaurantInput;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateRestaurantRequest {
    @NotNull
    private String name;

    @NotNull
    private List<String> areaIds;

    public CreateRestaurantInput toInput() {
        return new CreateRestaurantInput(name, areaIds);
    }
}
