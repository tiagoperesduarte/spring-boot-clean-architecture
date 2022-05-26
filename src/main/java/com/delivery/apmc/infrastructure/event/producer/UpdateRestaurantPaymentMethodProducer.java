package com.delivery.apmc.infrastructure.event.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.delivery.apmc.infrastructure.event.producer.payload.UpdateRestaurantPaymentMethodPayload;

@Component
public class UpdateRestaurantPaymentMethodProducer implements KafkaProducer<UpdateRestaurantPaymentMethodPayload> {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.restaurant-payment-method-update.topic}")
    private String topic;

    @Override
    public void produce(UpdateRestaurantPaymentMethodPayload payload) {
        kafkaTemplate.send(topic, payload.toJson());
    }
}
