package br.com.tw.lunchandlearn.presentation.endpoint.authentication;

import br.com.tw.lunchandlearn.domain.authentication.AuthenticationService;
import br.com.tw.lunchandlearn.presentation.endpoint.UserResponse;
import br.com.tw.lunchandlearn.domain.authentication.AuthenticationException;
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
public class AuthenticationEndpoint {

    private static final String ENCRYPTED = "$2a$10$dDWf0kiLKrsoFr89QKOoeeySRFAaLtMs3rTJCc1d8CFEekU8TCcg2";
    private static final String USERNAME = "fulano123";

    @Autowired
    private PasswordEncoder passwordEncoder;

    private AuthenticationService authenticationService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserResponse> login(@RequestBody CredentialsRequest credentialsRequest) {

        if(isValidCredentials(credentialsRequest)){
            UserResponse userResponse = new UserResponse();
            userResponse.firstName = "Fulano";
            userResponse.lastName = "Ciclano";
            userResponse.username = "fulano123";
            userResponse.office = "Belzonte";

            return ResponseEntity.ok(userResponse);
        } else {
            throw new AuthenticationException();
        }
    }

    public ResponseEntity<UserResponse> loginWithService(CredentialsRequest credentialsRequest) {
        UserResponse userResponse = authenticationService.authenticate(credentialsRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    private boolean isValidCredentials(CredentialsRequest credentialsRequest) {
        return credentialsRequest.username.equals(USERNAME) && passwordEncoder.matches(credentialsRequest.password, ENCRYPTED);
    }

}
