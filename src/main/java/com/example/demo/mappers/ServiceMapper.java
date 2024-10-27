package com.example.demo.mappers;

import com.example.demo.dtos.ServiceDTO;
import com.example.demo.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    @Mapping(target = "attraction", ignore = true)
    ServiceDTO toDTO(Service service);

    @Mapping(target = "attraction", ignore = true)
    Service toEntity(ServiceDTO serviceDTO);
}

