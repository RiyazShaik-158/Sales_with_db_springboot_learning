package com.learning.sales.controller;

import com.learning.sales.dto.Customer.CustomerRequestDto;
import com.learning.sales.dto.Customer.CustomerResponseDto;
import com.learning.sales.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponseDto> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Customer By Id")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponseDto getCustomerById(long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    @Operation(summary = "Add Customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
        customerService.addCustomer(customerRequestDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Customer")
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@PathVariable long id, @RequestBody @Valid CustomerRequestDto customerRequestDto) {
        customerService.updateCustomer(id, customerRequestDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Customer by Id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
    }
}
