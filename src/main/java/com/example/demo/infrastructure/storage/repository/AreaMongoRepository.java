package com.example.demo.infrastructure.storage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.infrastructure.storage.document.AreaDocument;

public interface AreaMongoRepository extends MongoRepository<AreaDocument, String> {
}
