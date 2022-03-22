package com.example.bibliotecafuncional.application.mappers;

import com.example.bibliotecafuncional.domain.collections.Resource;
import com.example.bibliotecafuncional.domain.dto.ResourceDTO;
import com.example.bibliotecafuncional.domain.valueObject.Availability;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Function;

@Component
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

    public Function<ResourceDTO, Resource> mapToNewCollection(){

        return resourceDTO -> new Resource(
                resourceDTO.getId(),
                resourceDTO.getName(),
                resourceDTO.getAuthor(),
                Availability.AVAILABLE,
                null,
                resourceDTO.getThematicArea(),
                resourceDTO.getTypeOfResource()
        );
    }

    public Function<Resource, ResourceDTO> mapToDTOWhenBorrow(){

        return resource -> new ResourceDTO(
                resource.getId(),
                resource.getName(),
                resource.getAuthor(),
                Availability.UNAVAILABLE,
                LocalDate.now(),
                resource.getThematicArea(),
                resource.getTypeOfResource()
        );
    }

    public Function<Resource, ResourceDTO> mapToDTOWhenReturn(){

        return resource -> new ResourceDTO(
                resource.getId(),
                resource.getName(),
                resource.getAuthor(),
                Availability.AVAILABLE,
                resource.getLastBorrowed(),
                resource.getThematicArea(),
                resource.getTypeOfResource()
        );
    }
}
