package com.example.demo.infrastructure.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.infrastructure.producer.payload.UpdateAreaPaymentMethodPayload;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UpdateAreaPaymentMethodProducer implements KafkaProducer<UpdateAreaPaymentMethodPayload> {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.microservice2.area-payment-method-update.topic}")
    private String topic;

    @Override
    public void produce(UpdateAreaPaymentMethodPayload payload) {
        log.debug("Producing event to update area payment method with data (data={})", payload);

        kafkaTemplate.send(topic, payload.toJson());
    }
}
