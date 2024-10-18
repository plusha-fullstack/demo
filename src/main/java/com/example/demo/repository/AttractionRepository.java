package com.example.demo.repository;

import com.example.demo.model.Attraction;
import com.example.demo.model.AttractionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    List<Attraction> findByType(AttractionType type);
    List<Attraction> findByCityId(Long cityId);
}
