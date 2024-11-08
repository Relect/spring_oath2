package com.example.spring_oath2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private String lastName;
    private String firstName;
    private String surname;
    private int group;
    private float averageRating;
}
