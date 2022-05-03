package com.example.demo.domain.entity;

import java.util.List;
import java.util.Objects;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Area {
    private String id;
    private String name;
    private AreaType type;
    private List<PaymentMethod> paymentMethods;

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.add(paymentMethod);
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
        return id.equals(area.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
