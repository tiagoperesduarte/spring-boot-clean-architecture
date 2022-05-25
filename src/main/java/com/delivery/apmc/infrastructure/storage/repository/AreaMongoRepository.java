package com.delivery.apmc.infrastructure.storage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.delivery.apmc.infrastructure.storage.document.AreaDocument;

public interface AreaMongoRepository extends MongoRepository<AreaDocument, String> {
}
