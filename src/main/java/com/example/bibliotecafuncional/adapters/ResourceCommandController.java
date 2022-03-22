package com.example.bibliotecafuncional.adapters;

import com.example.bibliotecafuncional.application.service.ResourceService;
import com.example.bibliotecafuncional.domain.dto.ResourceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/command/resource")
public class ResourceCommandController {

    private final ResourceService resourceService;

    // fill Data
    // localhost:8080/api/resource/fillData
    @PostMapping("/fillData")
    public ResponseEntity<List<ResourceDTO>> saveAll(@RequestBody List<ResourceDTO> resources){
        return new ResponseEntity<>(resourceService.fillData(resources), HttpStatus.OK);
    }

    // save Resource
    // localhost:8080/api/resource/saveResource
    @PostMapping("/saveResource")
    public ResponseEntity<ResourceDTO> saveResource(@RequestBody ResourceDTO resourceDTO){
        return new ResponseEntity<>(resourceService.saveResource(resourceDTO), HttpStatus.CREATED);
    }

    // update Resource
    // localhost:8080/api/resource/updateResource
    @PutMapping("/updateResource")
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

}
