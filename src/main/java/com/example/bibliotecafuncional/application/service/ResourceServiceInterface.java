package com.example.bibliotecafuncional.application.service;

import com.example.bibliotecafuncional.domain.dto.ResourceDTO;
import com.example.bibliotecafuncional.domain.valueObject.Availability;
import com.example.bibliotecafuncional.domain.valueObject.ThematicArea;
import com.example.bibliotecafuncional.domain.valueObject.TypeOfResource;

import java.util.List;
import java.util.Optional;

public interface ResourceServiceInterface {

    // basic CRUD services

    // save all data
    List<ResourceDTO> fillData(List<ResourceDTO> resourcesDto);

    // list Resource
    List<ResourceDTO> listResource();

    // find by id
    Optional<ResourceDTO> findById(String id);

    // save Resource
    ResourceDTO saveResource(ResourceDTO resourceDTO);

    // update Resource
    ResourceDTO updateResource(ResourceDTO resourceDTO);

    // delete Resource
    void deleteResource(String id);

    // delete All Resources
    void deleteAllResources();


    // other methods

    // find By availability
    List<ResourceDTO> findByAvailability(Availability availability);

    // borrow resource
    String borrowResource(String id);

    // return resource
    String returnResource(String id);

    // recommend By ThematicArea
    List<ResourceDTO> recommendThematicArea(ThematicArea thematicArea);

    // recommend By TypeOfResource
    List<ResourceDTO> recommendTypeOfResource(TypeOfResource typeOfResource);

    // recommend by both (ThematicArea, TypeOfResource)
    List<ResourceDTO> recommendThematicAreaAndTypeOfResource(ThematicArea thematicArea, TypeOfResource typeOfResource );

    // find By Author
    List<ResourceDTO> findByAuthor(String author);

    // find by name
    List<ResourceDTO> findByName(String name);

}
