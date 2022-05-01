package com.example.demo.infrastructure.storage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.infrastructure.storage.document.RegionDocument;

public interface RegionMongoRepository extends MongoRepository<RegionDocument, String> {
}
