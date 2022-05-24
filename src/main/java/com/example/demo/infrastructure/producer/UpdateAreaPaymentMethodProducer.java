package com.example.demo.infrastructure.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import com.example.demo.infrastructure.producer.payload.UpdateAreaPaymentMethodPayload;

public class UpdateAreaPaymentMethodProducer implements KafkaProducer<UpdateAreaPaymentMethodPayload> {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.microservice2.area-payment-method-update.topic}")
    private final String topic;

    public UpdateAreaPaymentMethodProducer(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void produce(UpdateAreaPaymentMethodPayload payload) {
        kafkaTemplate.send(topic, payload.toJson());
    }
}
