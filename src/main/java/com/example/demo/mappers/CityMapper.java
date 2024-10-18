package com.example.demo.mappers;

import com.example.demo.dtos.CityDTO;
import com.example.demo.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDTO toDTO(City city);
    City toEntity(CityDTO cityDTO);
}
