package com.example.bibliotecafuncional.domain.repository;

import com.example.bibliotecafuncional.domain.collections.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends MongoRepository<Resource, String> {

    /* BASIC CRUD SERVICES */
    // list Resource
    

    // find by id

    // save Resource

    // update Resource

    // delete Resource

    /* OTHER METHODS */
}
