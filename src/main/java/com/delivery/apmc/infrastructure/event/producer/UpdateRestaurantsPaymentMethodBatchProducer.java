package com.delivery.apmc.infrastructure.event.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.delivery.apmc.infrastructure.event.producer.payload.UpdateRestaurantsPaymentMethodBatchPayload;

@Component
public class UpdateRestaurantsPaymentMethodBatchProducer implements KafkaProducer<UpdateRestaurantsPaymentMethodBatchPayload> {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.restaurants-payment-method-update-batch.topic}")
    private String topic;

    @Override
    public void produce(UpdateRestaurantsPaymentMethodBatchPayload payload) {
        kafkaTemplate.send(topic, payload.toJson());
    }
}
