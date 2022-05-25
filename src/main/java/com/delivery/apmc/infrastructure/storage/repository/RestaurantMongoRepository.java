package com.delivery.apmc.infrastructure.storage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.delivery.apmc.infrastructure.storage.document.RestaurantDocument;

public interface RestaurantMongoRepository extends MongoRepository<RestaurantDocument, String> {
}
