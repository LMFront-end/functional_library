package com.example.bibliotecafuncional.domain.collections;

import com.example.bibliotecafuncional.domain.valueObject.Availability;
import com.example.bibliotecafuncional.domain.valueObject.MyDate;
import com.example.bibliotecafuncional.domain.valueObject.ThematicArea;
import com.example.bibliotecafuncional.domain.valueObject.TypeOfResource;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(value = "resources")
public class Resource {

    @Id
    private final String id;

    private final String name;
    private final String author;
    private final Availability availability;
    private final LocalDate lastBorrowed;
    private final ThematicArea thematicArea;
    private final TypeOfResource typeOfResource;

}
