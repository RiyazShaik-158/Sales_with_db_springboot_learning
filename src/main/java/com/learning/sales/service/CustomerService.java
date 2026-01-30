package com.learning.sales.service;

import com.learning.sales.dto.Customer.CustomerRequestDto;
import com.learning.sales.dto.Customer.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDto> getAllCustomers();

    CustomerResponseDto getCustomerById(long id);

    void addCustomer(CustomerRequestDto customerRequestDto);

    void updateCustomer(long id ,CustomerRequestDto customerRequestDto);

    void deleteCustomer(long id);
}
