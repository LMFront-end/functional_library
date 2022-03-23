package com.example.bibliotecafuncional.application.service;

import com.example.bibliotecafuncional.application.mappers.ResourceMapper;
import com.example.bibliotecafuncional.domain.collections.Resource;
import com.example.bibliotecafuncional.domain.dto.ResourceDTO;
import com.example.bibliotecafuncional.domain.repository.ResourceRepository;
import com.example.bibliotecafuncional.domain.valueObject.Availability;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class ResourceServiceTest {

    ResourceRepository resourceRepository = Mockito.mock(ResourceRepository.class);
    ResourceMapper resourceMapper = new ResourceMapper();
    ResourceService resourceService = new ResourceService(resourceRepository, resourceMapper);

    JsonReader jsonReader = new JsonReader();
    List<ResourceDTO> resourceDTOS = jsonReader.getResourceDTOS();
    List<Resource> resources = resourceDTOS.stream().map(resourceMapper.mapToCollection()).collect(Collectors.toList());

    @Test
    void fillData() {
        Mockito.when(resourceRepository.saveAll(Mockito.any())).thenReturn(resources);
        List<ResourceDTO> resourceDTOSTest = resourceService.fillData(resourceDTOS);
        Assertions.assertEquals(resourceDTOS, resourceDTOSTest);
        Mockito.verify(resourceRepository, Mockito.times(1)).saveAll(Mockito.any());

    }

    @Test
    void listResource() {
        Mockito.when(resourceRepository.findAll()).thenReturn(resources);
        List<ResourceDTO> resourceDTOSTest = resourceService.listResource();
        Assertions.assertEquals(resourceDTOS, resourceDTOSTest);
        Mockito.verify(resourceRepository, Mockito.times(1)).findAll();

    }

    @Test
    void findById() {
        String id = "62396c211a361d392b993163";
        Optional<ResourceDTO> resourceDTOTest = Optional.of(
                resourceDTOS.stream()
                        .filter(r -> r.getId().equals(id))
                        .collect(Collectors.toList()).get(0)
        );
        Resource resourceTest = resources.stream()
                .filter(r -> r.getId().equals(id))
                .collect(Collectors.toList()).get(0);
        Mockito.when(resourceRepository.findById(Mockito.any())).thenReturn(Optional.of(resourceTest));
        Optional<ResourceDTO> resourceDTOResponse = resourceService.findById(id);
        Assertions.assertEquals(resourceDTOResponse, resourceDTOTest);
        Mockito.verify(resourceRepository, Mockito.times(1)).findById(Mockito.any());

    }

    @Test
    void saveResource() {
        Resource resource = resources.get(0);
        ResourceDTO resourceDTOTest = resourceDTOS.get(0);
        Mockito.when(resourceRepository.save(Mockito.any())).thenReturn(resource);
        ResourceDTO resourceDTOResponse = resourceService.saveResource(resourceDTOTest);
        Assertions.assertEquals(resourceDTOResponse, resourceDTOTest);
        Mockito.verify(resourceRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void updateResource() {

        Resource resource = resources.get(0);
        ResourceDTO resourceDTOTest = resourceDTOS.get(0);
        resourceDTOTest.setAvailability(Availability.UNAVAILABLE);
        Resource updatedResource = new Resource(resource.getId(),
                resource.getName(),
                resource.getAuthor(),
                Availability.UNAVAILABLE,
                resource.getLastBorrowed(),
                resource.getThematicArea(),
                resource.getTypeOfResource()
        );

        Mockito.when(resourceRepository.findById(Mockito.any())).thenReturn(Optional.of(resource));
        Mockito.when(resourceRepository.save(Mockito.any())).thenReturn(updatedResource);

        ResourceDTO resourceDTOResponse = resourceService.updateResource(resourceDTOTest);
        Assertions.assertEquals(resourceDTOResponse, resourceDTOTest);
        Mockito.verify(resourceRepository, Mockito.times(1)).findById(Mockito.any());
        Mockito.verify(resourceRepository, Mockito.times(1)).save(Mockito.any());

    }

    @Test
    void deleteResource() {
        resourceService.deleteResource(Mockito.any());
        Mockito.verify(resourceRepository, Mockito.times(1)).deleteById(Mockito.any());
    }

    @Test
    void deleteAllResources() {
        resourceService.deleteAllResources();
        Mockito.verify(resourceRepository, Mockito.times(1)).deleteAll();

    }

    @Test
    void findByAvailability() {

        List<ResourceDTO> resourceDTOSTest = resourceDTOS.stream()
                .filter(r -> r.getAvailability().equals(Availability.AVAILABLE))
                .collect(Collectors.toList());
        List<Resource> resourcesTest = resources.stream()
                .filter(r -> r.getAvailability().equals(Availability.AVAILABLE))
                .collect(Collectors.toList());

        Mockito.when(resourceRepository.findByAvailability(Mockito.any())).thenReturn(resourcesTest);
        List<ResourceDTO> resourceDTOSResponse = resourceService.findByAvailability(Mockito.any());

        Assertions.assertEquals(resourceDTOSResponse, resourceDTOSTest);

        Mockito.verify(resourceRepository, Mockito.times(1)).findByAvailability(Mockito.any());
    }
}