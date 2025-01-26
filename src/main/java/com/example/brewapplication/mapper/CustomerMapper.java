package com.example.brewapplication.mapper;

import com.example.brewapplication.domain.Customer;
import com.example.brewapplication.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer custerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);
}
