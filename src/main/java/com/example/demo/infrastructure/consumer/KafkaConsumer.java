package com.example.demo.infrastructure.consumer;

import org.springframework.kafka.support.Acknowledgment;

public interface KafkaConsumer<P> {
    void consume(P payload, Acknowledgment ack);
}
