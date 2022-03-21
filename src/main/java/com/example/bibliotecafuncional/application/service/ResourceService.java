package com.example.bibliotecafuncional.application.service;

import com.example.bibliotecafuncional.domain.dto.ResourceDTO;
import com.example.bibliotecafuncional.domain.repository.ResourceRepository;
import com.example.bibliotecafuncional.domain.valueObject.Availability;
import com.example.bibliotecafuncional.domain.valueObject.ThematicArea;
import com.example.bibliotecafuncional.domain.valueObject.TypeOfResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ResourceService implements ResourceServiceInterface {

    private final ResourceRepository repository;

    @Override
    public List<ResourceDTO> listResource() {
        return null;
    }

    @Override
    public ResourceDTO saveResource(ResourceDTO resourceDTO) {
        return null;
    }

    @Override
    public ResourceDTO updateResource(ResourceDTO resourceDTO) {
        return null;
    }

    @Override
    public void deleteResource(String id) {

    }

    @Override
    public List<ResourceDTO> findByAvailability(Availability availability) {
        return null;
    }

    @Override
    public ResourceDTO borrowResource(String id) {
        return null;
    }

    @Override
    public ResourceDTO returnResource(String id) {
        return null;
    }

    @Override
    public List<ResourceDTO> recommendThematicArea(ThematicArea thematicArea) {
        return null;
    }

    @Override
    public List<ResourceDTO> recommendTypeOfResource(TypeOfResource typeOfResource) {
        return null;
    }

    @Override
    public List<ResourceDTO> recommendThematicAreaAndTypeOfResource(ThematicArea thematicArea, TypeOfResource typeOfResource) {
        return null;
    }

    @Override
    public List<ResourceDTO> findByAuthor(String author) {
        return null;
    }

    @Override
    public List<ResourceDTO> findByName(String name) {
        return null;
    }
}
