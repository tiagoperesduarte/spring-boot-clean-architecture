package com.example.demo.domain.exception;

public class InsufficientReasonException extends RuntimeException {
    public InsufficientReasonException(String message) {
        super(message);
    }
}