package br.com.tw.lunchandlearn.domain.authentication;

import br.com.tw.lunchandlearn.infrastructure.user.UserEntity;
import br.com.tw.lunchandlearn.infrastructure.user.UserRepository;
import br.com.tw.lunchandlearn.presentation.endpoint.UserResponse;
import br.com.tw.lunchandlearn.presentation.endpoint.authentication.CredentialsRequest;

public class AuthenticationService {

    private UserRepository userRepository;

    public UserResponse authenticate(CredentialsRequest credentialsRequest) {
        UserEntity userEntity = userRepository.findByUserName(credentialsRequest.username);

        UserResponse userResponse = new UserResponse();
        userResponse.firstName = userEntity.firstName;
        userResponse.username = credentialsRequest.username;

        return userResponse;
    }
}
