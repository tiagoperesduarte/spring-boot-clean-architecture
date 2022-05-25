package com.delivery.rpmc.infrastructure.storage.document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.delivery.rpmc.core.utils.CollectionUtils;
import com.delivery.rpmc.domain.entity.Restaurant;

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

        List<String> areaIds = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(restaurant.getAreaIds())) {
            areaIds = restaurant.getAreaIds();
        }

        return RestaurantDocument.builder()
                                 .id(id)
                                 .name(restaurant.getName())
                                 .areaIds(areaIds)
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
