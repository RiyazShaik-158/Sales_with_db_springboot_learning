package com.learning.sales.service.Impl;

import com.learning.sales.dto.Customer.CustomerResponseDto;
import com.learning.sales.entity.Customer;
import com.learning.sales.repo.CustomerRepo;
import com.learning.sales.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    private final CustomerRepo customerRepo;

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> originals =  customerRepo.findAll();
        return originals.stream()
                .map(this::mapToDto)
                .toList();
    }

    private CustomerResponseDto mapToDto(Customer customer) {
        return new CustomerResponseDto(customer.getId(), customer.getName(), customer.getAddress(), customer.getCity(), customer.getState(), customer.getZip());
    }
}
