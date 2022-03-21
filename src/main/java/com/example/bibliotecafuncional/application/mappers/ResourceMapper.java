package com.example.bibliotecafuncional.application.mappers;

import com.example.bibliotecafuncional.domain.collections.Resource;
import com.example.bibliotecafuncional.domain.dto.ResourceDTO;

import java.util.function.Function;

public class ResourceMapper {

    public Function<Resource, ResourceDTO> mapToDTO(){

        return resource -> new ResourceDTO(
                resource.getId(),
                resource.getName(),
                resource.getAuthor(),
                resource.getAvailability(),
                resource.getLastBorrowed(),
                resource.getThematicArea(),
                resource.getTypeOfResource()
        );

    }

    public Function<ResourceDTO, Resource> mapToCollection(){

        return resourceDTO -> new Resource(
                resourceDTO.getId(),
                resourceDTO.getName(),
                resourceDTO.getAuthor(),
                resourceDTO.getAvailability(),
                resourceDTO.getLastBorrowed(),
                resourceDTO.getThematicArea(),
                resourceDTO.getTypeOfResource()
        );
    }
}
