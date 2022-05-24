package com.example.demo.infrastructure.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.demo.domain.exception.DomainException;
import com.example.demo.domain.usecase.UpdateAreaPaymentMethodUseCase;
import com.example.demo.infrastructure.consumer.payload.UpdateAreaPaymentMethodPayload;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UpdateAreaPaymentMethodConsumer implements KafkaConsumer<UpdateAreaPaymentMethodPayload> {
    private final UpdateAreaPaymentMethodUseCase updateAreaPaymentMethodUseCase;

    public UpdateAreaPaymentMethodConsumer(UpdateAreaPaymentMethodUseCase updateAreaPaymentMethodUseCase) {
        this.updateAreaPaymentMethodUseCase = updateAreaPaymentMethodUseCase;
    }

    @KafkaListener(
            topics = "${app.microservice1.area-payment-method-update.topic}",
            containerFactory = "kafkaJsonListenerContainerFactory"
    )
    @Override
    public void consume(@Payload UpdateAreaPaymentMethodPayload payload, Acknowledgment ack) {
        log.debug("Consuming event to update area payment method with data (data={})", payload);

        try {
            updateAreaPaymentMethodUseCase.execute(payload.toInput());

            ack.acknowledge();
        } catch (DomainException ex) {
            log.error("Failed to process event to update area payment method with data (data={})", payload);

            ex.printStackTrace();
            ack.acknowledge();
        }
    }
}
