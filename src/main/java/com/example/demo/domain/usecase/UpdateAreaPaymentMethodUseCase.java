package com.example.demo.domain.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Area;
import com.example.demo.domain.exception.AreaNotFoundException;
import com.example.demo.domain.repository.AreaRepository;
import com.example.demo.domain.repository.PaymentMethodRepository;
import com.example.demo.domain.usecase.input.UpdateAreaPaymentMethodInput;

@Service
public class UpdateAreaPaymentMethodUseCase {
    private final AreaRepository areaRepository;
    private final PaymentMethodRepository paymentMethodRepository;

    public UpdateAreaPaymentMethodUseCase(
            AreaRepository areaRepository,
            PaymentMethodRepository paymentMethodRepository
    ) {
        this.areaRepository = areaRepository;
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public Area execute(UpdateAreaPaymentMethodInput input) {
        var area = areaRepository.findById(input.getAreaId())
                                 .orElseThrow(() -> new AreaNotFoundException("Area not found with id " + input.getAreaId()));

        area.addOrUpdatePaymentMethod(input.getPaymentMethod());
        paymentMethodRepository.update(input.getAreaId(), input.getPaymentMethod());

        return areaRepository.save(area);
    }
}
