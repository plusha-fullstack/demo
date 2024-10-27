package com.example.demo.dtos;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class AttractionDTO {
    private Long id;
    private String name;
    private LocalDate createdDate;
    private String description;
    private String type;
    private CityDTO city;
    private List<ServiceDTO> services;

}
