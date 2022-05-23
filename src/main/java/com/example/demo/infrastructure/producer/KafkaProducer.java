package com.example.demo.infrastructure.producer;

public interface KafkaProducer<P> {
    void produce(P payload);
}
