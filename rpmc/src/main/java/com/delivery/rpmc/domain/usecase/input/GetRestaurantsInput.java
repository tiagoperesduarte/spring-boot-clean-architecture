package com.delivery.rpmc.domain.usecase.input;

import com.delivery.rpmc.domain.entity.SimplePageRequest;

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
