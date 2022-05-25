package com.delivery.apmc.domain.usecase;

import org.springframework.stereotype.Service;

import com.delivery.apmc.domain.entity.Area;
import com.delivery.apmc.domain.exception.AreaNotFoundException;
import com.delivery.apmc.domain.repository.AreaRepository;
import com.delivery.apmc.domain.repository.RestaurantPaymentMethodRepository;
import com.delivery.apmc.domain.usecase.input.UpdateAreaPaymentMethodInput;

@Service
public class UpdateAreaPaymentMethodUseCase {
    private final AreaRepository areaRepository;
    private final RestaurantPaymentMethodRepository restaurantPaymentMethodRepository;

    public UpdateAreaPaymentMethodUseCase(
            AreaRepository areaRepository,
            RestaurantPaymentMethodRepository restaurantPaymentMethodRepository
    ) {
        this.areaRepository = areaRepository;
        this.restaurantPaymentMethodRepository = restaurantPaymentMethodRepository;
    }

    public Area execute(UpdateAreaPaymentMethodInput input) {
        var area = areaRepository.findById(input.getAreaId())
                                 .orElseThrow(() -> new AreaNotFoundException("Area not found with id " + input.getAreaId()));

        area.addOrUpdatePaymentMethod(input.getPaymentMethod());
        restaurantPaymentMethodRepository.updateByAreaId(input.getAreaId(), input.getPaymentMethod());

        return areaRepository.save(area);
    }
}
