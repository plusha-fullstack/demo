package com.example.demo.mappers;

import com.example.demo.dtos.AttractionDTO;
import com.example.demo.dtos.CityDTO;
import com.example.demo.dtos.ServiceDTO;
import com.example.demo.model.Attraction;
import com.example.demo.model.AttractionType;
import com.example.demo.model.City;
import com.example.demo.model.Service;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-27T15:30:40+0300",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AttractionMapperImpl implements AttractionMapper {

    @Override
    public AttractionDTO toDTO(Attraction attraction) {
        if ( attraction == null ) {
            return null;
        }

        AttractionDTO attractionDTO = new AttractionDTO();

        attractionDTO.setId( attraction.getId() );
        attractionDTO.setName( attraction.getName() );
        attractionDTO.setCreatedDate( attraction.getCreatedDate() );
        attractionDTO.setDescription( attraction.getDescription() );
        if ( attraction.getType() != null ) {
            attractionDTO.setType( attraction.getType().name() );
        }
        attractionDTO.setCity( cityToCityDTO( attraction.getCity() ) );

        return attractionDTO;
    }

    @Override
    public Attraction toEntity(AttractionDTO attractionDTO) {
        if ( attractionDTO == null ) {
            return null;
        }

        Attraction attraction = new Attraction();

        attraction.setId( attractionDTO.getId() );
        attraction.setName( attractionDTO.getName() );
        attraction.setCreatedDate( attractionDTO.getCreatedDate() );
        attraction.setDescription( attractionDTO.getDescription() );
        if ( attractionDTO.getType() != null ) {
            attraction.setType( Enum.valueOf( AttractionType.class, attractionDTO.getType() ) );
        }
        attraction.setServices( serviceDTOListToServiceList( attractionDTO.getServices() ) );

        return attraction;
    }

    protected List<AttractionDTO> attractionListToAttractionDTOList(List<Attraction> list) {
        if ( list == null ) {
            return null;
        }

        List<AttractionDTO> list1 = new ArrayList<AttractionDTO>( list.size() );
        for ( Attraction attraction : list ) {
            list1.add( toDTO( attraction ) );
        }

        return list1;
    }

    protected CityDTO cityToCityDTO(City city) {
        if ( city == null ) {
            return null;
        }

        CityDTO cityDTO = new CityDTO();

        cityDTO.setId( city.getId() );
        cityDTO.setName( city.getName() );
        cityDTO.setPopulation( city.getPopulation() );
        cityDTO.setHasMetro( city.isHasMetro() );
        cityDTO.setAttractions( attractionListToAttractionDTOList( city.getAttractions() ) );

        return cityDTO;
    }

    protected Service serviceDTOToService(ServiceDTO serviceDTO) {
        if ( serviceDTO == null ) {
            return null;
        }

        Service service = new Service();

        service.setId( serviceDTO.getId() );
        service.setName( serviceDTO.getName() );
        service.setDescription( serviceDTO.getDescription() );
        service.setAttraction( toEntity( serviceDTO.getAttraction() ) );

        return service;
    }

    protected List<Service> serviceDTOListToServiceList(List<ServiceDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Service> list1 = new ArrayList<Service>( list.size() );
        for ( ServiceDTO serviceDTO : list ) {
            list1.add( serviceDTOToService( serviceDTO ) );
        }

        return list1;
    }
}
