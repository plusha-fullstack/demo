package com.example.demo.controller;

import com.example.demo.dtos.CityDTO;
import com.example.demo.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public CityDTO addCity(@RequestBody CityDTO cityDTO) {
        return cityService.addCity(cityDTO);
    }

    @PutMapping("/{id}")
    public CityDTO updateCity(@PathVariable Long id, @RequestBody CityDTO cityDTO) {
        return cityService.updateCity(id, cityDTO);
    }

    @GetMapping
    public List<CityDTO> getAllCities() {
        return cityService.getAllCities();
    }
}
