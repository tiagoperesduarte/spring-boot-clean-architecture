package com.example.demo.infrastructure.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.demo.domain.usecase.UpdateAreaPaymentMethodUseCase;
import com.example.demo.infrastructure.consumer.payload.UpdateAreaPaymentMethodPayload;

@Component
public class UpdateAreaPaymentMethodConsumer implements Consumer<UpdateAreaPaymentMethodPayload> {
    private final UpdateAreaPaymentMethodUseCase updateAreaPaymentMethodUseCase;

    public UpdateAreaPaymentMethodConsumer(UpdateAreaPaymentMethodUseCase updateAreaPaymentMethodUseCase) {
        this.updateAreaPaymentMethodUseCase = updateAreaPaymentMethodUseCase;
    }

    @KafkaListener(
            topics = "${app.consumer.payment-method.topic}",
            containerFactory = "kafkaJsonListenerContainerFactory"
    )
    @Override
    public void consume(@Payload UpdateAreaPaymentMethodPayload payload) {
        updateAreaPaymentMethodUseCase.execute(payload.toInput());
    }
}
