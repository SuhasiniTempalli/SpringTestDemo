package com.example.brewapplication.services;

import com.example.brewapplication.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

     CustomerDto getCustomerId(UUID id);
}
