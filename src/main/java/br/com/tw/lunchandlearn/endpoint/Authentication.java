package br.com.tw.lunchandlearn.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class Authentication {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserResponse> login(@RequestBody CredentialsRequest credentialsRequest) {
        UserResponse userResponse = new UserResponse();
        userResponse.firstName = "Fulano";
        userResponse.lastName = "Ciclano";
        userResponse.username = "fulano123";

        return ResponseEntity.ok(userResponse);
    }
}
