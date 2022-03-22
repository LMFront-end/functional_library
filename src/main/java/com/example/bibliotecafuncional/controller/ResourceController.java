package com.example.bibliotecafuncional.controller;

import com.example.bibliotecafuncional.application.service.ResourceService;
import com.example.bibliotecafuncional.domain.collections.Resource;
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

    // fill Data
    // localhost:8080/api/resource/fillData
    @PostMapping("/fillData")
    public ResponseEntity<List<ResourceDTO>> saveAll(@RequestBody List<ResourceDTO> resources){
        return new ResponseEntity<>(resourceService.fillData(resources), HttpStatus.OK);
    }

    // list Resource
    // localhost:8080/api/resource/listResource
    @GetMapping("/listResource")
    public ResponseEntity<List<ResourceDTO>> listResource(){
        return new ResponseEntity<>(resourceService.listResource(), HttpStatus.OK);
    }

    // save Resource
    // localhost:8080/api/resource/saveResource
    @PostMapping("/saveResource")
    public ResponseEntity<ResourceDTO> saveResource(@RequestBody ResourceDTO resourceDTO){
        return new ResponseEntity<>(resourceService.saveResource(resourceDTO), HttpStatus.CREATED);
    }

    // find by id
    // localhost:8080/api/resource/findById?id={id}
    @GetMapping("/findById")
    public ResponseEntity<Optional<ResourceDTO>> findById(@RequestParam String id){
        return new ResponseEntity<>(resourceService.findById(id), HttpStatus.OK);
    }

    // update Resource
    // localhost:8080/api/resource/updateResorce
    @PutMapping("/updateResorce")
    public ResponseEntity<ResourceDTO> updateResource(@RequestBody ResourceDTO resourceDTO ){
        return new ResponseEntity<>(resourceService.updateResource(resourceDTO), HttpStatus.ACCEPTED);
    }

    // delete Resource
    // localhost:8080/api/resource/deleteResourceById?id={}
    @DeleteMapping("/deleteResourceById")
    public ResponseEntity<HttpStatus> deleteResource(@RequestParam String id){
        resourceService.deleteResource(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // delete All
    // localhost:8080/api/resource/deleteAll
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllResources(){
        resourceService.deleteAllResources();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // find By availability
    // localhost:8080/api/resource/findByAvailability?avail={}
    @GetMapping("/findByAvailability")
    public ResponseEntity<List<ResourceDTO>> findByAvailability(@RequestParam(name="avail") Availability availability){
        return new ResponseEntity<>(resourceService.findByAvailability(availability), HttpStatus.OK);
    }

    // borrow resource
    // localhost:8080/api/resource/borrowResource?borrow={}
    @PutMapping("/borrowResource")
    public ResponseEntity<String> borrowResource(@RequestParam(name="borrow") String id){
        return new ResponseEntity<>(resourceService.borrowResource(id), HttpStatus.ACCEPTED );
    }

    // return resource
    // localhost:8080/api/resource/returnResource?ret={}
    @PutMapping("/returnResource")
    public ResponseEntity<String> returnResource(@RequestParam(name="ret") String id){
        return new ResponseEntity<>(resourceService.returnResource(id), HttpStatus.ACCEPTED );
    }

    // recommend By ThematicArea
    // localhost:8080/api/resource/findByThematicArea?thema={}
    @GetMapping("/findByThematicArea")
    public ResponseEntity<List<ResourceDTO>> recommendThematicArea(@RequestParam(name="thema") ThematicArea thematicArea){
        return new ResponseEntity<>(resourceService.recommendThematicArea(thematicArea), HttpStatus.OK);
    }

    // recommend By TypeOfResource
    // localhost:8080/api/resource/findByTypeOfResource?type={}
    @GetMapping("/findByTypeOfResource")
    public ResponseEntity<List<ResourceDTO>>recommendTypeOfResource(@RequestParam(name="type") TypeOfResource typeOfResource){
        return new ResponseEntity<>(resourceService.recommendTypeOfResource(typeOfResource), HttpStatus.OK);
    }

    // recommend by both (ThematicArea, TypeOfResource)
    // localhost:8080/api/resource/findByThematicAndTypeOfResource?typeOf={}&themat={}
    @GetMapping("/findByThematicAndTypeOfResource")
    public ResponseEntity<List<ResourceDTO>> recommendThematicAreaAndTypeOfResource(@RequestParam(name="typeOf") TypeOfResource typeOfResource, @RequestParam(name="themat") ThematicArea thematicArea){
        return new ResponseEntity<>(resourceService.recommendThematicAreaAndTypeOfResource(thematicArea, typeOfResource), HttpStatus.OK);
    }

    // find By Author
    // localhost:8080/api/resource/findByAuthor?au={}
    @GetMapping("/findByAuthor")
    public ResponseEntity<List<ResourceDTO>>findByAuthor(@RequestParam(name="au") String author){
        return new ResponseEntity<>(resourceService.findByAuthor(author), HttpStatus.OK);
    }

    // find by name
    // localhost:8080/api/resource/findByName?na={}
    @GetMapping("/findByName")
    public ResponseEntity<List<ResourceDTO>>findByName(@RequestParam(name="na") String name){
        return new ResponseEntity<>(resourceService.findByName(name), HttpStatus.OK);
    }
}
