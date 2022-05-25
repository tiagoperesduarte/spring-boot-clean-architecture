package com.delivery.apmc.infrastructure.event.consumer;

import org.springframework.kafka.support.Acknowledgment;

public interface KafkaConsumer<P> {
    void consume(P payload, Acknowledgment ack);
}
