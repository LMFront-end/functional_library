package com.example.bibliotecafuncional.application.service;

import com.example.bibliotecafuncional.domain.dto.ResourceDTO;

import java.util.List;

public interface ResourceServiceInterface {

    // basic CRUD services

    // list Resource
    List<ResourceDTO> listResource();

    // save Resource
    ResourceDTO saveResource(ResourceDTO resourceDTO);

    // update Resource
    ResourceDTO updateResource(ResourceDTO resourceDTO);

    // delete Resource
    void deleteResource(String id);


}
