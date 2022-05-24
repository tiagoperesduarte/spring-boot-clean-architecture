package com.example.demo.infrastructure.producer.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.PaymentMethod;
import com.example.demo.domain.repository.PaymentMethodRepository;
import com.example.demo.infrastructure.producer.UpdateAreaPaymentMethodProducer;
import com.example.demo.infrastructure.producer.payload.UpdateAreaPaymentMethodPayload;

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
