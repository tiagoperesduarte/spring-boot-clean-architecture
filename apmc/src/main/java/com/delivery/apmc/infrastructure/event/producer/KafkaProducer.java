package com.delivery.apmc.infrastructure.event.producer;

public interface KafkaProducer<P> {
    void produce(P payload);
}
