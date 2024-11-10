package com.example.todo_oath2.repository;

import com.example.todo_oath2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * from students WHERE last_name = ?1 AND first_name = ?2 AND surname = ?3 ", nativeQuery = true)
    Student findByLastNameAndFirstNameAndSurname(String lastName, String firstName, String surname);
}
