package com.delivery.apmc.infrastructure.storage.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.delivery.apmc.infrastructure.storage.document.RestaurantDocument;

public interface RestaurantMongoRepository extends MongoRepository<RestaurantDocument, String> {
    Page<RestaurantDocument> findAllByAreaIdsOrderByCreatedOnAsc(String areaId, Pageable pageable);
}
