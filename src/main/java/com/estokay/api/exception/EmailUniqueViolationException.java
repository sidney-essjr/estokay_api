package com.estokay.api.exception;

public class EmailUniqueViolationException extends RuntimeException {
    public EmailUniqueViolationException(String message) {
        super(message);
    }
}
