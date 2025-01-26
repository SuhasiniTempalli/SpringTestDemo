package com.example.brewapplication.web.controller;

import com.example.brewapplication.services.CustomerService;
import com.example.brewapplication.web.model.BeerDto;
import com.example.brewapplication.web.model.CustomerDto;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomerDetails(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(customerService.getCustomerId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        CustomerDto customer = customerService.saveCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + customer.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity updateCustomer(@PathVariable UUID id,@Valid @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(id,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCustomer(@PathVariable UUID id){
        customerService.deleteCustomer(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}

