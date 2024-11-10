package com.example.todo_oath2.Controller;

import com.example.todo_oath2.dto.StudentDto;
import com.example.todo_oath2.model.Student;
import com.example.todo_oath2.repository.StudentRepo;
import com.example.todo_oath2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    OAuth2AuthorizedClientService clientService;
    @Autowired
    StudentService service;

    @GetMapping
    public ResponseEntity<String > getToken(OAuth2AuthenticationToken oauthToken) {
        OAuth2AuthorizedClient client =
                clientService.loadAuthorizedClient(
                        oauthToken.getAuthorizedClientRegistrationId(),
                        oauthToken.getName()
                );
        String accesToken = client.getAccessToken().getTokenValue();
        return ResponseEntity.ok(accesToken);

    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> updateStudent(@RequestBody StudentDto studentDto) {
        return Optional
                .ofNullable(service.updateStudent(studentDto))
                .map(student -> ResponseEntity.ok().body(student))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(service.addStudent(studentDto));
    }

    @DeleteMapping("/students")
    public ResponseEntity<Student> deleteStudent(@RequestBody StudentDto studentDto) {
        return Optional
                .ofNullable(service.deleteStudent(studentDto))
                .map(student -> ResponseEntity.ok().body(student))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
