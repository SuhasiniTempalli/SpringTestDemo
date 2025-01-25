package com.example.brewapplication.services;

import com.example.brewapplication.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public CustomerDto getCustomerId(UUID id) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("Suhasini").build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("Suhasini").build();
    }

    @Override
    public void updateCustomer(UUID id, CustomerDto customerDto) {
        //todo
    }

    @Override
    public void deleteCustomer(UUID id) {
        //todo
    }
}
