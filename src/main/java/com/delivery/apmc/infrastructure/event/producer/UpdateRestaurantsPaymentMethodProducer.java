package com.delivery.apmc.infrastructure.event.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.delivery.apmc.infrastructure.event.producer.payload.UpdateRestaurantsPaymentMethodPayload;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UpdateRestaurantsPaymentMethodProducer implements KafkaProducer<UpdateRestaurantsPaymentMethodPayload> {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.restaurants-payment-method-update.topic}")
    private String topic;

    @Override
    public void produce(UpdateRestaurantsPaymentMethodPayload payload) {
        log.debug("Producing event to update restaurants payment method with data (data={})", payload);

        kafkaTemplate.send(topic, payload.toJson());
    }
}
