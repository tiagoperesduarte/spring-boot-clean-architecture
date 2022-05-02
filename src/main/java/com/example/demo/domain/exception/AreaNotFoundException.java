package com.example.demo.domain.exception;

public class AreaNotFoundException extends RuntimeException {
    public AreaNotFoundException(String message) {
        super(message);
    }
}