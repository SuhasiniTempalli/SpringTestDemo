package com.example.brewapplication.mapper;

import com.example.brewapplication.domain.Beer;
import com.example.brewapplication.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
