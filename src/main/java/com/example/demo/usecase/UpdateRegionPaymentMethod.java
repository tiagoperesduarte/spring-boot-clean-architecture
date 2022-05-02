package com.example.demo.usecase;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Region;
import com.example.demo.domain.exception.RegionNotFoundException;
import com.example.demo.domain.repository.RegionRepository;
import com.example.demo.usecase.dto.input.UpdateRegionPaymentMethodInput;

@Service
public class UpdateRegionPaymentMethod {
    private final RegionRepository repository;

    public UpdateRegionPaymentMethod(RegionRepository repository) {
        this.repository = repository;
    }

    public Region execute(UpdateRegionPaymentMethodInput input) {
        var region = repository.findById(input.getRegionId())
                               .orElseThrow(() -> new RegionNotFoundException("Region not found with id " + input.getRegionId()));

        region.getPaymentMethods()
              .stream()
              .filter(paymentMethod -> paymentMethod.equals(input.getPaymentMethod()))
              .findFirst()
              .ifPresentOrElse(
                      paymentMethod -> paymentMethod.setStatus(input.getPaymentMethod().isStatus()),
                      () -> region.addPaymentMethod(input.getPaymentMethod())
              );

        return repository.save(region);
    }
}
