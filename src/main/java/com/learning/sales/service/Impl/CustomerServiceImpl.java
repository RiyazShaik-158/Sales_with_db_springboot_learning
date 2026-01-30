package com.learning.sales.service.Impl;

import com.learning.sales.dto.Customer.CustomerRequestDto;
import com.learning.sales.dto.Customer.CustomerResponseDto;
import com.learning.sales.entity.Customer;
import com.learning.sales.exception.CustomerNotFoundError;
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

    @Override
    public CustomerResponseDto getCustomerById(long id) {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundError( "Customer not found with id: " + id));
        return mapToDto(customer);
    }

    @Override
    public void addCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();
        customer.setName(customerRequestDto.getName());
        customer.setAddress(customerRequestDto.getAddress());
        customer.setCity(customerRequestDto.getCity());
        customer.setState(customerRequestDto.getState());
        customer.setZip(customerRequestDto.getZip());
        customerRepo.save(customer);
    }

    @Override
    public void updateCustomer(long id, CustomerRequestDto customerRequestDto) {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundError( "Customer not found with id: " + id));
        customer.setName(customerRequestDto.getName());
        customer.setAddress(customerRequestDto.getAddress());
        customer.setCity(customerRequestDto.getCity());
        customer.setState(customerRequestDto.getState());
        customer.setZip(customerRequestDto.getZip());
        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        if(customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        } else {
            throw new CustomerNotFoundError( "Customer not found with id: " + id);
        }
    }

    private CustomerResponseDto mapToDto(Customer customer) {
        return new CustomerResponseDto(customer.getId(), customer.getName(), customer.getAddress(), customer.getCity(), customer.getState(), customer.getZip());
    }
}
