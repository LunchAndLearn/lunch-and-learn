package br.com.tw.lunchandlearn.presentation.endpoint;

import br.com.tw.lunchandlearn.presentation.request.CredentialsRequest;
import br.com.tw.lunchandlearn.presentation.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class Authentication {

    private static final String ENCRYPTED = "$2a$10$dDWf0kiLKrsoFr89QKOoeeySRFAaLtMs3rTJCc1d8CFEekU8TCcg2";
    private static final String USERNAME = "fulano123";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserResponse> login(@RequestBody CredentialsRequest credentialsRequest) {

        if(isValidCredentials(credentialsRequest)){
            UserResponse.Office office = new UserResponse.Office();
            office.name = "Belzonte";

            UserResponse userResponse = new UserResponse();
            userResponse.name = "Fulano";
            userResponse.lastName = "Ciclano";
            userResponse.user = "fulano123";
            userResponse.office = office;

            return ResponseEntity.ok(userResponse);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    private boolean isValidCredentials(CredentialsRequest credentialsRequest) {
        return isEqualsUserName(credentialsRequest) && isMatchesPassword(credentialsRequest);
    }

    private boolean isEqualsUserName(CredentialsRequest credentialsRequest) {
        return credentialsRequest.username.equals(USERNAME);
    }

    private boolean isMatchesPassword(CredentialsRequest credentialsRequest) {
        return passwordEncoder.matches(credentialsRequest.password, ENCRYPTED);
    }

}
