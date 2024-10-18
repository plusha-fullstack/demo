package com.example.demo.service;

import com.example.demo.dtos.CityDTO;
import com.example.demo.mappers.CityMapper;
import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    private CityMapper cityMapper = CityMapper.INSTANCE;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addCity() {
        City city = new City();
        city.setName("Test City");
        when(cityRepository.save(any(City.class))).thenReturn(city);

        CityDTO cityDTO = new CityDTO();
        cityDTO.setName("Test City");
        CityDTO savedCity = cityService.addCity(cityDTO);

        assertEquals("Test City", savedCity.getName());
        verify(cityRepository, times(1)).save(any(City.class));
    }

    @Test
    void updateCity() {
        City city = new City();
        city.setId(1L);
        city.setName("Old City");
        city.setPopulation(1000);
        when(cityRepository.findById(anyLong())).thenReturn(Optional.of(city));
        when(cityRepository.save(any(City.class))).thenReturn(city);

        CityDTO cityDTO = new CityDTO();
        cityDTO.setPopulation(2000);
        cityDTO.setHasMetro(true);
        CityDTO updatedCity = cityService.updateCity(1L, cityDTO);

        assertEquals(2000, updatedCity.getPopulation());
        assertTrue(updatedCity.isHasMetro());
        verify(cityRepository, times(1)).save(any(City.class));
    }
}
