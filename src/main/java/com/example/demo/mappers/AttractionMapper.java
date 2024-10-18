package com.example.demo.mappers;

import com.example.demo.dtos.AttractionDTO;
import com.example.demo.model.Attraction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AttractionMapper {
    AttractionMapper INSTANCE = Mappers.getMapper(AttractionMapper.class);

    AttractionDTO toDTO(Attraction attraction);
    Attraction toEntity(AttractionDTO attractionDTO);
}
