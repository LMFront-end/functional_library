package com.example.bibliotecafuncional.application.service;

import com.example.bibliotecafuncional.domain.dto.ResourceDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Getter
public class JsonReader {

    private final String path = "src/main/java/com/example/bibliotecafuncional/domain/utils/Responses.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<ResourceDTO> resourceDTOS;

    public JsonReader(){
        try{
            resourceDTOS = objectMapper.readValue(new File(path), new TypeReference<>() {});
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
