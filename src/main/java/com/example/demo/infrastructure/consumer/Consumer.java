package com.example.demo.infrastructure.consumer;

import org.springframework.kafka.support.Acknowledgment;

public interface Consumer<P> {
    void consume(P payload, Acknowledgment ack);
}
