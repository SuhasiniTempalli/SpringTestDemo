package com.example.brewapplication.services;

import com.example.brewapplication.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
