package com.learning.sales.exception;

public class CustomerNotFoundError extends RuntimeException{

    public CustomerNotFoundError(String message) {
        super(message);
    }

    public CustomerNotFoundError(Throwable cause) {
        super(cause);
    }

    public CustomerNotFoundError(String message, Throwable cause) {
        super(message, cause);
    }
}
