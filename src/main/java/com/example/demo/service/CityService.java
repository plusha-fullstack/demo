package com.example.demo.service;

import com.example.demo.dtos.CityDTO;
import com.example.demo.mappers.CityMapper;
import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper = CityMapper.INSTANCE;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public CityDTO addCity(CityDTO cityDTO) {
        City city = cityMapper.toEntity(cityDTO);
        City savedCity = cityRepository.save(city);
        log.info("City added: {}", savedCity.getName());
        return cityMapper.toDTO(savedCity);
    }

    public CityDTO updateCity(Long id, CityDTO cityDTO) {
        City city = cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found"));
        city.setPopulation(cityDTO.getPopulation());
        city.setHasMetro(cityDTO.isHasMetro());
        City updatedCity = cityRepository.save(city);
        log.info("City updated: {}", updatedCity.getName());
        return cityMapper.toDTO(updatedCity);
    }

    public List<CityDTO> getAllCities() {
        log.info("Fetching all cities");
        return cityRepository.findAll().stream()
                .map(cityMapper::toDTO)
                .collect(Collectors.toList());
    }
}

