package com.example.demo.domain.exception;

public class AreaNotFoundException extends DomainException {
    public AreaNotFoundException(String message) {
        super(message);
    }
}