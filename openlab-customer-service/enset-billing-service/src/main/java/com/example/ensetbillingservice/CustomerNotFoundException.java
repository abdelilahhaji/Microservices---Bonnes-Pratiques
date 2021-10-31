package com.example.ensetbillingservice;


public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String messages) {
        super(messages);
    }
}
