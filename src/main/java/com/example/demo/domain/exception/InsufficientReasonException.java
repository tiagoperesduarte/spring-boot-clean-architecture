package com.example.demo.domain.exception;

public class InsufficientReasonException extends DomainException {
    public InsufficientReasonException(String message) {
        super(message);
    }
}