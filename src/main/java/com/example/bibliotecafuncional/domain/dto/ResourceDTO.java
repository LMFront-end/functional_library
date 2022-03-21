package com.example.bibliotecafuncional.domain.dto;


import com.example.bibliotecafuncional.domain.valueObject.Availability;
import com.example.bibliotecafuncional.domain.valueObject.ThematicArea;
import com.example.bibliotecafuncional.domain.valueObject.TypeOfResource;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ResourceDTO {

    private final String id;

    private final String name;
    private final String author;
    private final Availability availability;
    private final LocalDate lastBorrowed;
    private final ThematicArea thematicArea;
    private final TypeOfResource typeOfResource;
}
