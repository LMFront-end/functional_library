package com.example.bibliotecafuncional.adapters;

import com.example.bibliotecafuncional.application.service.ResourceService;
import com.example.bibliotecafuncional.domain.dto.ResourceDTO;
import com.example.bibliotecafuncional.domain.valueObject.Availability;
import com.example.bibliotecafuncional.domain.valueObject.ThematicArea;
import com.example.bibliotecafuncional.domain.valueObject.TypeOfResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/query/resource")
public class ResourceQueryController {

    private final ResourceService resourceService;

    // list Resource
    // localhost:8080/api/query/resource/listResource
    @GetMapping("/listResource")
    public ResponseEntity<List<ResourceDTO>> listResource(){
        return new ResponseEntity<>(resourceService.listResource(), HttpStatus.OK);
    }

    // find by id
    // localhost:8080/api/query/resource/findById?id={id}
    @GetMapping("/findById")
    public ResponseEntity<Optional<ResourceDTO>> findById(@RequestParam String id){
        return new ResponseEntity<>(resourceService.findById(id), HttpStatus.OK);
    }

    // find By availability
    // localhost:8080/api/query/resource/findByAvailability?avail={}
    @GetMapping("/findByAvailability")
    public ResponseEntity<List<ResourceDTO>> findByAvailability(@RequestParam(name="avail") Availability availability){
        return new ResponseEntity<>(resourceService.findByAvailability(availability), HttpStatus.OK);
    }

    // recommend By ThematicArea
    // localhost:8080/api/query/resource/findByThematicArea?thema={}
    @GetMapping("/findByThematicArea")
    public ResponseEntity<List<ResourceDTO>> recommendThematicArea(@RequestParam(name="thema") ThematicArea thematicArea){
        return new ResponseEntity<>(resourceService.recommendThematicArea(thematicArea), HttpStatus.OK);
    }

    // recommend By TypeOfResource
    // localhost:8080/api/query/resource/findByTypeOfResource?type={}
    @GetMapping("/findByTypeOfResource")
    public ResponseEntity<List<ResourceDTO>>recommendTypeOfResource(@RequestParam(name="type") TypeOfResource typeOfResource){
        return new ResponseEntity<>(resourceService.recommendTypeOfResource(typeOfResource), HttpStatus.OK);
    }

    // recommend by both (ThematicArea, TypeOfResource)
    // localhost:8080/api/query/resource/findByThematicAndTypeOfResource?typeOf={}&themat={}
    @GetMapping("/findByThematicAndTypeOfResource")
    public ResponseEntity<List<ResourceDTO>> recommendThematicAreaAndTypeOfResource(@RequestParam(name="typeOf") TypeOfResource typeOfResource, @RequestParam(name="themat") ThematicArea thematicArea){
        return new ResponseEntity<>(resourceService.recommendThematicAreaAndTypeOfResource(thematicArea, typeOfResource), HttpStatus.OK);
    }

    // find By Author
    // localhost:8080/api/query/resource/findByAuthor?au={}
    @GetMapping("/findByAuthor")
    public ResponseEntity<List<ResourceDTO>>findByAuthor(@RequestParam(name="au") String author){
        return new ResponseEntity<>(resourceService.findByAuthor(author), HttpStatus.OK);
    }

    // find by name
    // localhost:8080/api/query/resource/findByName?na={}
    @GetMapping("/findByName")
    public ResponseEntity<List<ResourceDTO>>findByName(@RequestParam(name="na") String name){
        return new ResponseEntity<>(resourceService.findByName(name), HttpStatus.OK);
    }

}
