package com.delivery.apmc.domain.exception;

public class RestaurantNotFoundException extends DomainException {
    public RestaurantNotFoundException(String message) {
        super(message);
    }
}