package com.example.demo.dtos;

import lombok.Data;

@Data
public class ServiceDTO {
    private Long id;
    private String name;
    private String description;
    private AttractionDTO attraction;
}
