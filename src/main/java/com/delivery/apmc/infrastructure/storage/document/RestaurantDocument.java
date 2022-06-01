package com.delivery.apmc.infrastructure.storage.document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.delivery.apmc.core.utils.CollectionUtils;
import com.delivery.apmc.domain.entity.Restaurant;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection = "restaurants")
@CompoundIndexes({
        @CompoundIndex(name = "area_ids_id_idx",
                       def = "{'areaIds' : 1, 'id': 1}"),
        @CompoundIndex(name = "area_ids_created_on_idx",
                       def = "{'areaIds' : 1, 'createdOn': 1}")
})
public class RestaurantDocument {
    @Id
    private String id;

    private String name;

    @Indexed
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
                                 .createdOn(LocalDateTime.now())
                                 .updatedOn(LocalDateTime.now())
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
