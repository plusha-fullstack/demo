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

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-18T15:35:21+0300",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public ServiceDTO toDTO(Service service) {
        if ( service == null ) {
            return null;
        }

        ServiceDTO serviceDTO = new ServiceDTO();

        serviceDTO.setId( service.getId() );
        serviceDTO.setName( service.getName() );
        serviceDTO.setDescription( service.getDescription() );
        serviceDTO.setAttraction( attractionToAttractionDTO( service.getAttraction() ) );

        return serviceDTO;
    }

    @Override
    public Service toEntity(ServiceDTO serviceDTO) {
        if ( serviceDTO == null ) {
            return null;
        }

        Service service = new Service();

        service.setId( serviceDTO.getId() );
        service.setName( serviceDTO.getName() );
        service.setDescription( serviceDTO.getDescription() );
        service.setAttraction( attractionDTOToAttraction( serviceDTO.getAttraction() ) );

        return service;
    }

    protected List<AttractionDTO> attractionListToAttractionDTOList(List<Attraction> list) {
        if ( list == null ) {
            return null;
        }

        List<AttractionDTO> list1 = new ArrayList<AttractionDTO>( list.size() );
        for ( Attraction attraction : list ) {
            list1.add( attractionToAttractionDTO( attraction ) );
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

    protected List<ServiceDTO> serviceListToServiceDTOList(List<Service> list) {
        if ( list == null ) {
            return null;
        }

        List<ServiceDTO> list1 = new ArrayList<ServiceDTO>( list.size() );
        for ( Service service : list ) {
            list1.add( toDTO( service ) );
        }

        return list1;
    }

    protected AttractionDTO attractionToAttractionDTO(Attraction attraction) {
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
        attractionDTO.setServices( serviceListToServiceDTOList( attraction.getServices() ) );

        return attractionDTO;
    }

    protected List<Attraction> attractionDTOListToAttractionList(List<AttractionDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Attraction> list1 = new ArrayList<Attraction>( list.size() );
        for ( AttractionDTO attractionDTO : list ) {
            list1.add( attractionDTOToAttraction( attractionDTO ) );
        }

        return list1;
    }

    protected City cityDTOToCity(CityDTO cityDTO) {
        if ( cityDTO == null ) {
            return null;
        }

        City city = new City();

        city.setId( cityDTO.getId() );
        city.setName( cityDTO.getName() );
        city.setPopulation( cityDTO.getPopulation() );
        city.setHasMetro( cityDTO.isHasMetro() );
        city.setAttractions( attractionDTOListToAttractionList( cityDTO.getAttractions() ) );

        return city;
    }

    protected List<Service> serviceDTOListToServiceList(List<ServiceDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Service> list1 = new ArrayList<Service>( list.size() );
        for ( ServiceDTO serviceDTO : list ) {
            list1.add( toEntity( serviceDTO ) );
        }

        return list1;
    }

    protected Attraction attractionDTOToAttraction(AttractionDTO attractionDTO) {
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
        attraction.setCity( cityDTOToCity( attractionDTO.getCity() ) );
        attraction.setServices( serviceDTOListToServiceList( attractionDTO.getServices() ) );

        return attraction;
    }
}
