package com.delivery.apmc.domain.entity;

import java.util.List;
import java.util.Objects;

import com.delivery.apmc.domain.exception.InsufficientReasonException;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Area {
    private String id;
    private String name;
    private AreaType type;
    private List<PaymentMethod> paymentMethods;

    public void addOrUpdatePaymentMethod(PaymentMethod newPaymentMethod) {
        this.paymentMethods
                .stream()
                .filter(paymentMethod -> paymentMethod.equals(newPaymentMethod))
                .findFirst()
                .ifPresentOrElse(
                        paymentMethod -> updatePaymentMethod(paymentMethod, newPaymentMethod),
                        () -> addPaymentMethod(newPaymentMethod)
                );
    }

    private void addPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.add(paymentMethod);
    }

    private void updatePaymentMethod(PaymentMethod paymentMethod, PaymentMethod newPaymentMethod) {
        if (paymentMethod.getReason().hasPriority(newPaymentMethod.getReason())) {
            throw new InsufficientReasonException(
                    String.format("Payment method %s cannot be updated, insufficient reason", paymentMethod.getType())
            );
        }

        paymentMethod.setStatus(newPaymentMethod.isStatus());
        paymentMethod.setReason(newPaymentMethod.getReason());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Area area = (Area) o;
        return Objects.equals(id, area.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
