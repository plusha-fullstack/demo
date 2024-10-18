package com.example.demo.mappers;

import com.example.demo.dtos.ServiceDTO;
import com.example.demo.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceMapper {
    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    ServiceDTO toDTO(Service service);
    Service toEntity(ServiceDTO serviceDTO);
}
