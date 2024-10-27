package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.List;

@Data
public class CityDTO {
    private Long id;
    private String name;
    private int population;
    private boolean hasMetro;
    private List<AttractionDTO> attractions;
}
