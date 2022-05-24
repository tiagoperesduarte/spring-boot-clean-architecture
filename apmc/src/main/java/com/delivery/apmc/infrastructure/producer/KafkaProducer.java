package com.delivery.apmc.infrastructure.producer;

public interface KafkaProducer<P> {
    void produce(P payload);
}
