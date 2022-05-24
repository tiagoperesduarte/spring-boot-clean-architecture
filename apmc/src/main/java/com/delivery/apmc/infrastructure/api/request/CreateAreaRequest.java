package com.delivery.apmc.infrastructure.api.request;

import javax.validation.constraints.NotNull;

import com.delivery.apmc.domain.entity.AreaType;
import com.delivery.apmc.domain.usecase.input.CreateAreaInput;

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
