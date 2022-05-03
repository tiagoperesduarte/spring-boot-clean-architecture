package com.example.demo.domain.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Area;
import com.example.demo.domain.exception.AreaNotFoundException;
import com.example.demo.domain.repository.AreaRepository;
import com.example.demo.domain.usecase.dto.input.UpdateAreaPaymentMethodInput;

@Service
public class UpdateAreaPaymentMethod {
    private final AreaRepository repository;

    public UpdateAreaPaymentMethod(AreaRepository repository) {
        this.repository = repository;
    }

    public Area execute(UpdateAreaPaymentMethodInput input) {
        var area = repository.findById(input.getAreaId())
                             .orElseThrow(() -> new AreaNotFoundException("Area not found with id " + input.getAreaId()));

        area.getPaymentMethods()
            .stream()
            .filter(paymentMethod -> paymentMethod.equals(input.getPaymentMethod()))
            .findFirst()
            .ifPresentOrElse(
                    paymentMethod -> paymentMethod.setStatus(input.getPaymentMethod().isStatus()),
                    () -> area.addPaymentMethod(input.getPaymentMethod())
            );

        return repository.save(area);
    }
}
