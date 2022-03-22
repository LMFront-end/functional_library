package com.example.bibliotecafuncional.domain.dto;


import com.example.bibliotecafuncional.domain.valueObject.Availability;
import com.example.bibliotecafuncional.domain.valueObject.ThematicArea;
import com.example.bibliotecafuncional.domain.valueObject.TypeOfResource;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO {

    private String id;

    private String name;
    private String author;
    private Availability availability;
    private LocalDate lastBorrowed;
    private ThematicArea thematicArea;
    private TypeOfResource typeOfResource;
}
