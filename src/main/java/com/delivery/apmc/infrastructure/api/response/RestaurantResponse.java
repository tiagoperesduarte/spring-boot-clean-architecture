package com.delivery.apmc.infrastructure.api.response;

import java.util.List;

import com.delivery.apmc.domain.entity.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestaurantResponse {
    private String id;
    private String name;
    private List<String> areaIds;

    public static RestaurantResponse of(Restaurant restaurant) {
        return new RestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getAreaIds()
        );
    }
}
