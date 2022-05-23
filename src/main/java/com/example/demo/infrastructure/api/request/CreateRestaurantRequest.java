package com.example.demo.infrastructure.api.request;

import javax.validation.constraints.NotNull;

import java.util.List;

import com.example.demo.domain.usecase.input.CreateRestaurantInput;

import lombok.Getter;

@Getter
public class CreateRestaurantRequest {
    @NotNull
    private String name;

    @NotNull
    private List<String> areaIds;

    public CreateRestaurantInput toInput() {
        return new CreateRestaurantInput(name, areaIds);
    }
}
