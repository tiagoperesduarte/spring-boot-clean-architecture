package com.delivery.rpmc.infrastructure.storage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.delivery.rpmc.infrastructure.storage.document.RestaurantDocument;

public interface RestaurantMongoRepository extends MongoRepository<RestaurantDocument, String> {
}
