package com.example.todo_oath2.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private String lastName;
    private String firstName;
    private String surname;
    private int party;
    private float averageRating;
}
