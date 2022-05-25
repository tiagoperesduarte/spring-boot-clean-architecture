package com.delivery.apmc.infrastructure.repository;

import org.springframework.stereotype.Repository;

import com.delivery.apmc.domain.entity.PaymentMethod;
import com.delivery.apmc.domain.repository.PaymentMethodRepository;
import com.delivery.apmc.infrastructure.event.producer.UpdateAreaPaymentMethodProducer;
import com.delivery.apmc.infrastructure.event.producer.payload.UpdateAreaPaymentMethodPayload;

@Repository
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {
    private final UpdateAreaPaymentMethodProducer updateAreaPaymentMethodProducer;

    public PaymentMethodRepositoryImpl(UpdateAreaPaymentMethodProducer updateAreaPaymentMethodProducer) {
        this.updateAreaPaymentMethodProducer = updateAreaPaymentMethodProducer;
    }

    @Override
    public void update(String areaId, PaymentMethod paymentMethod) {
        updateAreaPaymentMethodProducer.produce(UpdateAreaPaymentMethodPayload.of(areaId, paymentMethod));
    }
}