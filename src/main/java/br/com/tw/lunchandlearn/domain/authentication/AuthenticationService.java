package br.com.tw.lunchandlearn.domain.authentication;

import br.com.tw.lunchandlearn.infrastructure.User;
import br.com.tw.lunchandlearn.infrastructure.UserRepository;
import br.com.tw.lunchandlearn.presentation.endpoint.UserResponse;
import br.com.tw.lunchandlearn.presentation.endpoint.authentication.CredentialsRequest;

public class AuthenticationService {

    private UserRepository userRepository;

    public UserResponse authenticate(CredentialsRequest credentialsRequest) {
        User user = userRepository.findByUsername(credentialsRequest.username);

        UserResponse userResponse = new UserResponse();
        userResponse.firstName = user.name;
        userResponse.username = credentialsRequest.username;

        return userResponse;
    }
}
