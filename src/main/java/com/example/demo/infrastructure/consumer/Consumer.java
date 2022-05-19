package com.example.demo.infrastructure.consumer;

public interface Consumer<P> {
    void consume(P payload);
}
