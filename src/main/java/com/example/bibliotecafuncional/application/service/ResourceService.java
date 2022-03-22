package com.example.bibliotecafuncional.application.service;

import com.example.bibliotecafuncional.application.mappers.ResourceMapper;
import com.example.bibliotecafuncional.domain.utils.Message;
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
    public List<ResourceDTO> fillData(List<ResourceDTO> resources) {

        return resourceRepository.saveAll(resources.stream()
                        .map(resourceMapper.mapToNewCollection())
                        .collect(Collectors.toList()))
                .stream()
                .map(resourceMapper.mapToDTO())
                .collect(Collectors.toList());
    }

    // list Resource
    @Override
    public List<ResourceDTO> listResource() {
        return resourceRepository.findAll()
                .stream()
                .map(resourceMapper.mapToDTO())
                .collect(Collectors.toList());
    }

    // find by id
    @Override
    public Optional<ResourceDTO> findById(String id) {
        return resourceRepository.findById(id)
                .map(resourceMapper.mapToDTO());
    }

    // save Resource
    @Override
    public ResourceDTO saveResource(ResourceDTO resourceDTO) {
        return resourceMapper.mapToDTO()
                .apply(resourceRepository.save(resourceMapper.mapToNewCollection()
                        .apply(resourceDTO)));
    }

    // update Resource
    @Override
    public ResourceDTO updateResource(ResourceDTO resourceDTO) {

        if(resourceRepository.findById(resourceDTO.getId()).isEmpty()){
            throw new IllegalArgumentException(Message.RESOURCE_NOT_FOUND);
        }
        return resourceMapper.mapToDTO().apply(resourceRepository.save(resourceMapper.mapToCollection().apply(resourceDTO)));

    }

    // delete Resource
    @Override
    public void deleteResource(String id) {
        resourceRepository.deleteById(id);
    }

    // delete All
    @Override
    public void deleteAllResources() {
        resourceRepository.deleteAll();
    }

    // other methods
    @Override
    public List<ResourceDTO> findByAvailability(Availability availability) {
        return resourceRepository.findByAvailability(availability)
                .stream()
                .map(resourceMapper.mapToDTO())
                .collect(Collectors.toList());
    }

    // borrow resource
    @Override
    public String borrowResource(String id) {

        return resourceRepository.findByIdAndAvailability(id, Availability.AVAILABLE)
                .map(resourceMapper.mapToDTOWhenBorrow())
                .map(resourceDTO -> resourceRepository.save(resourceMapper.mapToCollection().apply(resourceDTO)))
                .map(resource -> Message.BORROWED_SUCCESSFULLY)
                .orElse(Message.RESOURCE_NOT_FOUND_NOT_AVAILABLE);
    }

    // return resource
    @Override
    public String returnResource(String id) {

        return resourceRepository.findByIdAndAvailability(id, Availability.UNAVAILABLE)
                .map(resourceMapper.mapToDTOWhenReturn())
                .map(resourceDTO -> resourceRepository.save(resourceMapper.mapToCollection().apply(resourceDTO)))
                .map(resource -> Message.BORROWED_SUCCESSFULLY)
                .orElse(Message.RESOURCE_NOT_FOUND_AVAILABLE);
    }

    // recommend By ThematicArea
    @Override
    public List<ResourceDTO> recommendThematicArea(ThematicArea thematicArea) {
        return resourceRepository.findAllByThematicAreaOrderByName(thematicArea)
                .stream()
                .map(resourceMapper.mapToDTO())
                .collect(Collectors.toList());
    }

    // recommend By TypeOfResource
    @Override
    public List<ResourceDTO> recommendTypeOfResource(TypeOfResource typeOfResource) {
        return resourceRepository.findAllByTypeOfResourceOrderByName(typeOfResource)
                .stream()
                .map(resourceMapper.mapToDTO())
                .collect(Collectors.toList());

    }

    // recommend by both (ThematicArea, TypeOfResource)
    @Override
    public List<ResourceDTO> recommendThematicAreaAndTypeOfResource(ThematicArea thematicArea, TypeOfResource typeOfResource) {
        return resourceRepository.findAllByThematicAreaAndTypeOfResourceOrderByName(thematicArea, typeOfResource)
                .stream()
                .map(resourceMapper.mapToDTO())
                .collect(Collectors.toList());
    }

    // find By Author
    @Override
    public List<ResourceDTO> findByAuthor(String author) {
        return resourceRepository.findAllByAuthorContainingIgnoreCaseOrderByName(author)
                .stream()
                .map(resourceMapper.mapToDTO())
                .collect(Collectors.toList());
    }

    // find by name
    @Override
    public List<ResourceDTO> findByName(String name) {
        return resourceRepository.findAllByNameContainingIgnoreCaseOrderByName(name)
                .stream()
                .map(resourceMapper.mapToDTO())
                .collect(Collectors.toList());
    }
}
