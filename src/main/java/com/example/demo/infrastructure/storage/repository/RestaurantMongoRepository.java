package com.example.demo.infrastructure.storage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.infrastructure.storage.document.RestaurantDocument;

public interface RestaurantMongoRepository extends MongoRepository<RestaurantDocument, String> {
}
