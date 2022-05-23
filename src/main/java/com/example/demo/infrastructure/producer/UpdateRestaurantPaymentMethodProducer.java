package com.example.demo.infrastructure.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import com.example.demo.infrastructure.producer.payload.UpdateRestaurantPaymentMethodPayload;

public class UpdateRestaurantPaymentMethodProducer implements KafkaProducer<UpdateRestaurantPaymentMethodPayload> {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.producer.restaurant-payment-method-update.topic}")
    private final String topic;

    public UpdateRestaurantPaymentMethodProducer(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void produce(UpdateRestaurantPaymentMethodPayload payload) {
        kafkaTemplate.send(topic, payload.toJson());
    }
}
