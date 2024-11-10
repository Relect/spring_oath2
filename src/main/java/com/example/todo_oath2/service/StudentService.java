package com.example.todo_oath2.service;

import com.example.todo_oath2.dto.StudentDto;
import com.example.todo_oath2.model.Student;
import com.example.todo_oath2.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;

    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public Student updateStudent(StudentDto studentDto) {
        Student student = studentRepo.findByLastNameAndFirstNameAndSurname(studentDto.getLastName(),
                studentDto.getFirstName(),
                studentDto.getSurname());
        if (student != null) {
            student.setParty(studentDto.getParty());
            student.setAverageRating(studentDto.getAverageRating());
            studentRepo.save(student);
        }
        return student;
    }

    public Student addStudent(StudentDto studentDto ) {
        Student student = Student.builder()
                .lastName(studentDto.getLastName())
                .firstName(studentDto.getFirstName())
                .surname(studentDto.getSurname())
                .party(studentDto.getParty())
                .averageRating(studentDto.getAverageRating())
                .build();
        studentRepo.save(student);
        return student;
    }

    public Student deleteStudent(StudentDto studentDto) {
        Student student = studentRepo.findByLastNameAndFirstNameAndSurname(studentDto.getLastName(),
                studentDto.getFirstName(),
                studentDto.getSurname());
        if (student != null) {
            studentRepo.delete(student);
        }
        return student;
    }
}

