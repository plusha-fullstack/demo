package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ServiceDTO {
    private Long id;
    private String name;
    private String description;
    @JsonIgnore
    private AttractionDTO attraction;
}
