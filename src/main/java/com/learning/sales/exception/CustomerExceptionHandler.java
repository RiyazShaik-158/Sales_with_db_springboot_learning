package com.learning.sales.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<CustomerResponseError> handleError(CustomerBadRequestError customerBadRequestError) {
        CustomerResponseError error = new CustomerResponseError(HttpStatus.BAD_REQUEST.value(), customerBadRequestError.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<CustomerResponseError> handleNotFoundError(CustomerNotFoundError customerNotFoundError) {
        CustomerResponseError error = new CustomerResponseError(HttpStatus.NOT_FOUND.value(), customerNotFoundError.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
