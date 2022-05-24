package com.example.demo.infrastructure.api.request;

import javax.validation.constraints.NotNull;

import com.example.demo.domain.entity.AreaType;
import com.example.demo.domain.usecase.input.CreateAreaInput;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateAreaRequest {
    @NotNull
    private String name;

    @NotNull
    private AreaType type;

    public CreateAreaInput toInput() {
        return new CreateAreaInput(name, type);
    }
}
