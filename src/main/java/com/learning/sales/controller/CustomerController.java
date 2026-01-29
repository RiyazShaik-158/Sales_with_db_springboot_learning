package com.learning.sales.controller;

import com.learning.sales.dto.Customer.CustomerResponseDto;
import com.learning.sales.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Tag(name = "Customer Controller", description = "Customer API")
public class CustomerController {

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private final CustomerService customerService;

    @GetMapping
    @Operation(summary = "Get All Customers")
    public List<CustomerResponseDto> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Customer By Id")
    public CustomerResponseDto getCustomerById(long id) {
        return customerService.getCustomerById(id);
    }
}
