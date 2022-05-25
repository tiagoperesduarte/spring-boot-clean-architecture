package com.delivery.apmc.domain.usecase.input;

import com.delivery.apmc.domain.entity.SimplePageRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetRestaurantsInput {
    private final int page;
    private final int size;

    public SimplePageRequest toEntity() {
        return new SimplePageRequest(
                page,
                size
        );
    }
}
