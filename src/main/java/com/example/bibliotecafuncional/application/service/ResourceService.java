package com.example.bibliotecafuncional.application.service;

import com.example.bibliotecafuncional.application.mappers.ResourceMapper;
import com.example.bibliotecafuncional.domain.dto.ResourceDTO;
import com.example.bibliotecafuncional.domain.repository.ResourceRepository;
import com.example.bibliotecafuncional.domain.valueObject.Availability;
import com.example.bibliotecafuncional.domain.valueObject.ThematicArea;
import com.example.bibliotecafuncional.domain.valueObject.TypeOfResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ResourceService implements ResourceServiceInterface {

    // repository
    private final ResourceRepository resourceRepository;

    // Mapper
    private final ResourceMapper resourceMapper;

    @Override
    public List<ResourceDTO> listResource() {
        return resourceRepository.findAll()
                .stream()
                .map(resourceMapper.mapToDTO())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ResourceDTO> findById(String id) {
        return resourceRepository.findById(id)
                .map(resourceMapper.mapToDTO());
    }

    @Override
    public ResourceDTO saveResource(ResourceDTO resourceDTO) {
        return resourceMapper.mapToDTO()
                .apply(resourceRepository.save(resourceMapper.mapToNewCollection()
                        .apply(resourceDTO)));
    }

    @Override
    public ResourceDTO updateResource(ResourceDTO resourceDTO) {
        return null;
    }

    @Override
    public void deleteResource(String id) {}

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
