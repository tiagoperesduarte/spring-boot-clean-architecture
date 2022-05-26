package com.delivery.apmc.infrastructure.event.consumer;

import java.time.Duration;
import java.time.Instant;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.delivery.apmc.domain.exception.DomainException;
import com.delivery.apmc.domain.usecase.UpdateRestaurantsPaymentMethodUseCase;
import com.delivery.apmc.infrastructure.event.consumer.payload.UpdateRestaurantsPaymentMethodPayload;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UpdateRestaurantsPaymentMethodConsumer implements KafkaConsumer<UpdateRestaurantsPaymentMethodPayload> {
    private final UpdateRestaurantsPaymentMethodUseCase updateRestaurantsPaymentMethodUseCase;

    public UpdateRestaurantsPaymentMethodConsumer(UpdateRestaurantsPaymentMethodUseCase updateRestaurantsPaymentMethodUseCase) {
        this.updateRestaurantsPaymentMethodUseCase = updateRestaurantsPaymentMethodUseCase;
    }

    @KafkaListener(
            topics = "${app.restaurants-payment-method-update.topic}",
            containerFactory = "kafkaJsonListenerContainerFactory"
    )
    @Override
    public void consume(@Payload UpdateRestaurantsPaymentMethodPayload payload, Acknowledgment ack) {
        log.debug("Consuming event to update restaurants payment method with data (data={})", payload);

        try {
            Instant start = Instant.now();

            updateRestaurantsPaymentMethodUseCase.execute(payload.toInput());

            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toSeconds();

            log.debug("Event to update restaurants payment method with data (data={}) successfully finished in {} seconds duration.", payload, timeElapsed);

            ack.acknowledge();
        } catch (DomainException ex) {
            log.error("Failed to process event to update restaurants payment method with data (data={})", payload);

            ex.printStackTrace();
            ack.acknowledge();
        }
    }
}
