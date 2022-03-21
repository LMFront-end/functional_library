package com.example.bibliotecafuncional.domain.valueObject;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class MyDate {

    private final LocalDate date;

    public MyDate(String inputDate) {
        date = LocalDate.parse(inputDate);
    }

    // after
    public Boolean isAfter(MyDate myDate){
        return date.isAfter(myDate.getDate());
    }

    // before
    public Boolean isBefore(MyDate myDate){
        return date.isBefore(myDate.getDate());
    }

    // equal
    public Boolean isEqual(MyDate myDate){
        return date.isEqual(myDate.getDate());
    }
}
