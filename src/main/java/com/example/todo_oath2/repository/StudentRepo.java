package com.example.todo_oath2.repository;

import com.example.todo_oath2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
