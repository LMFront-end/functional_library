package com.example.bibliotecafuncional.domain.repository;

import com.example.bibliotecafuncional.domain.collections.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends MongoRepository<Resource, String> {
}
