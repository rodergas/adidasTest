package com.adidas.test.email.exceptions;

public class EmailException extends RuntimeException {
    public EmailException() {

    }

    public EmailException(String message) {
        super(message);
    }
}
