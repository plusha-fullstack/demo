package com.example.demo.mappers;

import com.example.demo.dtos.AttractionDTO;
import com.example.demo.model.Attraction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses = {ServiceMapper.class, CityMapper.class})
public interface AttractionMapper {
    AttractionMapper INSTANCE = Mappers.getMapper(AttractionMapper.class);

    @Mapping(source = "city", target = "city")
    @Mapping(source = "services", target = "services")
    AttractionDTO toDTO(Attraction attraction);

    @Mapping(target = "services", ignore = true)
    @Mapping(target = "city", ignore = true)
    Attraction toEntity(AttractionDTO attractionDTO);
}

