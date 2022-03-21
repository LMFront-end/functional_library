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
}
