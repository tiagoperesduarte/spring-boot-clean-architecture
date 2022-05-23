package com.example.demo.infrastructure.api.response;

import java.util.List;

import com.example.demo.domain.entity.Restaurant;

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
