package com.example.bibliotecafuncional.controller;

import com.example.bibliotecafuncional.application.service.ResourceService;
import com.example.bibliotecafuncional.domain.dto.ResourceDTO;
import com.example.bibliotecafuncional.domain.valueObject.Availability;
import com.example.bibliotecafuncional.domain.valueObject.ThematicArea;
import com.example.bibliotecafuncional.domain.valueObject.TypeOfResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    private final ResourceService resourceService;

    // list Resource
    @GetMapping("/listResource")
    public ResponseEntity<List<ResourceDTO>> listResource(){
        return new ResponseEntity<>(resourceService.listResource(), HttpStatus.OK);
    }

    // save Resource
    @PostMapping("/saveResource")
    public ResponseEntity<ResourceDTO> saveResource(@RequestBody ResourceDTO resourceDTO){
        return new ResponseEntity<>(resourceService.saveResource(resourceDTO), HttpStatus.CREATED);
    }

    // find by id
    @GetMapping("/findById")
    public ResponseEntity<Optional<ResourceDTO>> findById(@RequestParam String id){
        return new ResponseEntity<>(resourceService.findById(id), HttpStatus.OK);
    }

    // delete Resource
    @DeleteMapping("/deleteResourceById")
    public ResponseEntity<HttpStatus> deleteResource(@RequestParam String id){
        resourceService.deleteResource(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // find By availability
    @GetMapping("/findByAvailability")
    public ResponseEntity<List<ResourceDTO>> findByAvailability(@RequestParam(name="aval") Availability availability){
        return new ResponseEntity<>(resourceService.findByAvailability(availability), HttpStatus.OK);
    }

    // recommend By ThematicArea
    @GetMapping("/findByThematicArea")
    public ResponseEntity<List<ResourceDTO>> recommendThematicArea(@RequestParam(name="thema") ThematicArea thematicArea){
        return new ResponseEntity<>(resourceService.recommendThematicArea(thematicArea), HttpStatus.OK);
    }

    // recommend By TypeOfResource
    @GetMapping("/findByTypeOfResource")
    public ResponseEntity<List<ResourceDTO>>recommendTypeOfResource(@RequestParam(name="type") TypeOfResource typeOfResource){
        return new ResponseEntity<>(resourceService.recommendTypeOfResource(typeOfResource), HttpStatus.OK);
    }

    // recommend by both (ThematicArea, TypeOfResource)
    @GetMapping("/findByThematicAndTypeOfResource")
    public ResponseEntity<List<ResourceDTO>> recommendThematicAreaAndTypeOfResource(@RequestParam(name="typeOf") TypeOfResource typeOfResource, @RequestParam(name="themat") ThematicArea thematicArea){
        return new ResponseEntity<>(resourceService.recommendThematicAreaAndTypeOfResource(thematicArea, typeOfResource), HttpStatus.OK);
    }

    // find By Author
    @GetMapping("/findByAuthor")
    public ResponseEntity<List<ResourceDTO>>findByAuthor(@RequestParam String author){
        return new ResponseEntity<>(resourceService.findByAuthor(author), HttpStatus.OK);
    }

    // find by name
    @GetMapping("/findByName")
    public ResponseEntity<List<ResourceDTO>>findByName(@RequestParam String name){
        return new ResponseEntity<>(resourceService.findByName(name), HttpStatus.OK);
    }
}
