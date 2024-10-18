package com.example.demo.service;

import com.example.demo.dtos.AttractionDTO;
import com.example.demo.mappers.AttractionMapper;
import com.example.demo.model.Attraction;
import com.example.demo.model.AttractionType;
import com.example.demo.model.City;
import com.example.demo.repository.AttractionRepository;
import com.example.demo.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AttractionService {

    private final AttractionRepository attractionRepository;
    private final CityRepository cityRepository;
    private AttractionMapper attractionMapper = AttractionMapper.INSTANCE;

    @Autowired
    public AttractionService(AttractionRepository attractionRepository,
                             CityRepository cityRepository,
                             AttractionMapper attractionMapper) {
        this.attractionRepository = attractionRepository;
        this.cityRepository = cityRepository;
        this.attractionMapper = attractionMapper;
    }

//    public AttractionDTO addAttraction(AttractionDTO attractionDTO) {
//        Attraction attraction = attractionMapper.toEntity(attractionDTO);
//        Attraction savedAttraction = attractionRepository.save(attraction);
//        log.info("Attraction added: {}", savedAttraction.getName());
//        return attractionMapper.toDTO(savedAttraction);
//    }
public AttractionDTO addAttraction(AttractionDTO attractionDTO) {
    Attraction attraction = attractionMapper.toEntity(attractionDTO);

    // Установим связь с сервисами
    if (attraction.getServices() != null) {
        for (com.example.demo.model.Service service : attraction.getServices()) {
            service.setAttraction(attraction);  // Устанавливаем аттракцион для каждого сервиса
        }
    }

    Attraction savedAttraction = attractionRepository.save(attraction);
    log.info("Attraction added: {}", savedAttraction.getName());
    return attractionMapper.toDTO(savedAttraction);
}

//    public AttractionDTO addAttraction(AttractionDTO attractionDTO) {  this is last variant!!
//        // Извлекаем идентификатор города из DTO
//        Long cityId = attractionDTO.getCity().getId();
//
//        // Находим город по идентификатору
//        City city = cityRepository.findById(cityId)
//                .orElseThrow(() -> new RuntimeException("City not found with id: " + cityId));
//
//        // Преобразуем DTO в сущность Attraction
//        Attraction attraction = attractionMapper.toEntity(attractionDTO);
//
//        // Устанавливаем найденный город в сущность Attraction
//        attraction.setCity(city);
//
//        // Сохраняем Attraction
//        Attraction savedAttraction = attractionRepository.save(attraction);
//
//        log.info("Attraction added: {}", savedAttraction.getName());
//
//        // Преобразуем сохраненную сущность обратно в DTO
//        return attractionMapper.toDTO(savedAttraction);
//    }

//    public AttractionDTO addAttraction(AttractionDTO attractionDTO) {
//        // Найдем город по cityId
//        City city = cityRepository.findById(attractionDTO.getCityId())
//                .orElseThrow(() -> new RuntimeException("City not found with id: " + attractionDTO.getCityId()));
//        // Преобразуем DTO в сущность
//        Attraction attraction = attractionMapper.toEntity(attractionDTO);
//        // Установим город в объекте Attraction
//        attraction.setCity(city);
//        // Сохраним объект Attraction
//        Attraction savedAttraction = attractionRepository.save(attraction);
//        log.info("Attraction added: {}", savedAttraction.getName());
//        // Преобразуем обратно в DTO и вернем результат
//        return attractionMapper.toDTO(savedAttraction);
//    }


    public AttractionDTO updateAttractionDescription(Long id, String newDescription) {
        Attraction attraction = attractionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attraction not found"));
        attraction.setDescription(newDescription);
        Attraction updatedAttraction = attractionRepository.save(attraction);
        log.info("Attraction description updated: {}", updatedAttraction.getName());
        return attractionMapper.toDTO(updatedAttraction);
    }

    public void deleteAttraction(Long id) {
        attractionRepository.deleteById(id);
        log.info("Attraction deleted: {}", id);
    }

    public List<AttractionDTO> getAllAttractions(AttractionType type) {
        log.info("Fetching all attractions of type: {}", type);
        return attractionRepository.findByType(type).stream()
                .map(attractionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<AttractionDTO> getAttractionsByCity(Long cityId) {
        log.info("Fetching all attractions for city with ID: {}", cityId);
        return attractionRepository.findByCityId(cityId).stream()
                .map(attractionMapper::toDTO)
                .collect(Collectors.toList());
    }
}
