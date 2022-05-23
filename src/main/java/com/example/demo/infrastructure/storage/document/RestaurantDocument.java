package com.example.demo.infrastructure.storage.document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.core.utils.CollectionUtils;
import com.example.demo.domain.entity.Restaurant;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection = "restaurants")
public class RestaurantDocument {
    @Id
    private String id;

    private String name;
    private List<String> areaIds;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public static RestaurantDocument of(Restaurant restaurant) {
        String id = null;

        if (restaurant.getId() != null) {
            id = restaurant.getId();
        }

        return RestaurantDocument.builder()
                                 .id(id)
                                 .name(restaurant.getName())
                                 .areaIds(restaurant.getAreaIds())
                                 .build();
    }

    public Restaurant toEntity() {
        List<String> areaIds = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(this.areaIds)) {
            areaIds = this.areaIds;
        }

        return Restaurant.builder()
                         .id(id)
                         .name(name)
                         .areaIds(areaIds)
                         .build();
    }
}
