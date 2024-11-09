package com.example.todo_oath2.Controller;

import com.example.todo_oath2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    OAuth2AuthorizedClientService clientService;

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
    public ResponseEntity<String > getStudents() {
        return ResponseEntity.ok("return students");
    }
}
