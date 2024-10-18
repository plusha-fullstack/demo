package com.example.demo.controller;

import com.example.demo.dtos.AttractionDTO;
import com.example.demo.model.AttractionType;
import com.example.demo.service.AttractionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attractions")
public class AttractionController {

    private final AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @PostMapping
    public AttractionDTO addAttraction(@RequestBody AttractionDTO attractionDTO) {
        return attractionService.addAttraction(attractionDTO);
    }

    @PutMapping("/{id}/description")
    public AttractionDTO updateAttractionDescription(@PathVariable Long id, @RequestBody String newDescription) {
        return attractionService.updateAttractionDescription(id, newDescription);
    }

    @DeleteMapping("/{id}")
    public void deleteAttraction(@PathVariable Long id) {
        attractionService.deleteAttraction(id);
    }

    @GetMapping
    public List<AttractionDTO> getAllAttractions(@RequestParam(required = false) AttractionType type) {
        return attractionService.getAllAttractions(type);
    }

    @GetMapping("/city/{cityId}")
    public List<AttractionDTO> getAttractionsByCity(@PathVariable Long cityId) {
        return attractionService.getAttractionsByCity(cityId);
    }
}
