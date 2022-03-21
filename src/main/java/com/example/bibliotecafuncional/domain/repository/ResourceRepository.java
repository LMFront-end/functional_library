package com.example.bibliotecafuncional.domain.repository;

import com.example.bibliotecafuncional.domain.collections.Resource;
import com.example.bibliotecafuncional.domain.dto.ResourceDTO;
import com.example.bibliotecafuncional.domain.valueObject.Availability;
import com.example.bibliotecafuncional.domain.valueObject.ThematicArea;
import com.example.bibliotecafuncional.domain.valueObject.TypeOfResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends MongoRepository<Resource, String> {

    /* OTHER METHODS */

    // find By availability
    List<Resource> findByAvailability(Availability availability);

    // recommend By ThematicArea
    List<Resource> findAllByThematicAreaOrderByName(ThematicArea thematicArea);

    // recommend By TypeOfResource
    List<Resource> findAllByTypeOfResourceOrderByName(TypeOfResource typeOfResource);

    // recommend by both (ThematicArea, TypeOfResource)
    List<Resource> findAllByThematicAreaAndTypeOfResourceOrderByName(ThematicArea thematicArea, TypeOfResource typeOfResource );

    // find By Author
    List<Resource> findAllByAuthorContainingIgnoreCaseOrderByName(String author);

    // find by name
    List<Resource> findAllByNameContainingIgnoreCaseOrderByName(String name);
}
