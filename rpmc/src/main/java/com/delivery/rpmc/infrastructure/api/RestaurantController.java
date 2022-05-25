package com.delivery.rpmc.infrastructure.api;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.rpmc.domain.usecase.CreateRestaurantUseCase;
import com.delivery.rpmc.domain.usecase.DeleteRestaurantUseCase;
import com.delivery.rpmc.domain.usecase.GetRestaurantUseCase;
import com.delivery.rpmc.domain.usecase.GetRestaurantsUseCase;
import com.delivery.rpmc.domain.usecase.input.GetRestaurantsInput;
import com.delivery.rpmc.infrastructure.api.request.CreateRestaurantRequest;
import com.delivery.rpmc.infrastructure.api.response.RestaurantResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class RestaurantController {
    private final GetRestaurantsUseCase getRestaurantsUseCase;
    private final GetRestaurantUseCase getRestaurantUseCase;
    private final CreateRestaurantUseCase createRestaurantUseCase;
    private final DeleteRestaurantUseCase deleteRestaurantUseCase;

    public RestaurantController(
            GetRestaurantsUseCase getRestaurantsUseCase,
            GetRestaurantUseCase getRestaurantUseCase,
            CreateRestaurantUseCase createRestaurantUseCase,
            DeleteRestaurantUseCase deleteRestaurantUseCase
    ) {
        this.getRestaurantsUseCase = getRestaurantsUseCase;
        this.getRestaurantUseCase = getRestaurantUseCase;
        this.createRestaurantUseCase = createRestaurantUseCase;
        this.deleteRestaurantUseCase = deleteRestaurantUseCase;
    }

    @GetMapping(value = "/restaurants")
    public Page<RestaurantResponse> getRestaurants(Pageable pageable) {
        log.debug("Request to find all restaurants by query (query={})", pageable);

        var input = new GetRestaurantsInput(pageable.getPageNumber(), pageable.getPageSize());
        var simplePage = getRestaurantsUseCase.execute(input)
                                              .map(RestaurantResponse::of);

        return new PageImpl<>(simplePage.getContent(), pageable, simplePage.getTotalElements());
    }

    @GetMapping(value = "/restaurants/{restaurantId}")
    public RestaurantResponse getRestaurant(@PathVariable String restaurantId) {
        log.debug("Request to find restaurant by id (id={})", restaurantId);

        var restaurant = getRestaurantUseCase.execute(restaurantId);
        return RestaurantResponse.of(restaurant);
    }

    @PostMapping(value = "/restaurants")
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantResponse createRestaurant(@Valid @RequestBody CreateRestaurantRequest request) {
        log.debug("Request to create new restaurant with data (data={})", request);

        var restaurant = createRestaurantUseCase.execute(request.toInput());
        return RestaurantResponse.of(restaurant);
    }

    @DeleteMapping(value = "/restaurants/{restaurantId}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable String restaurantId) {
        log.debug("Request to delete restaurant by id (id={})", restaurantId);

        deleteRestaurantUseCase.execute(restaurantId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
