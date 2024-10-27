package com.example.demo.mappers;

import com.example.demo.dtos.CityDTO;
import com.example.demo.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Mapping(target = "attractions", ignore = true)
    CityDTO toDTO(City city);
    @Mapping(target = "attractions", ignore = true)
    City toEntity(CityDTO cityDTO);
}

