package com.adidas.test.publicservice.exceptions;

public class SubscriptionNotFoundException extends RuntimeException{
    public SubscriptionNotFoundException() {

    }

    public SubscriptionNotFoundException(String message) {
        super(message);
    }
}
