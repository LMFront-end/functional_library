package com.example.bibliotecafuncional.controller;

import com.example.bibliotecafuncional.application.service.ResourceService;
import com.example.bibliotecafuncional.domain.dto.ResourceDTO;
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
    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<ResourceDTO>> findById(@PathVariable String id){
        return new ResponseEntity<>(resourceService.findById(id), HttpStatus.OK);
    }
}
