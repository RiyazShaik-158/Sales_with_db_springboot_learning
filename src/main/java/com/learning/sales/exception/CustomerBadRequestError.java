package com.learning.sales.exception;

public class CustomerBadRequestError extends RuntimeException{
    public CustomerBadRequestError(String message) {
        super(message);
    }

    public CustomerBadRequestError(Throwable cause) {
        super(cause);
    }

    public CustomerBadRequestError(String message, Throwable cause) {
        super(message, cause);
    }
}
