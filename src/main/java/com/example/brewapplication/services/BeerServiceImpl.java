package com.example.brewapplication.services;

import com.example.brewapplication.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    //To Test the beer service impl
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .upc(3435345L)
                .build();
    }

    /**
     * @param beerDto
     * @return
     */
    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId,BeerDto beerDto){
        //todo impl - would add a real impl to update beergit
    }

    public void deleteById(UUID beerId) {
        //log.debug("Deleting a beer...");
    }
}

