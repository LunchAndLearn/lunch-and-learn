package br.com.tw.lunchandlearn.fixture.user;

import br.com.tw.lunchandlearn.presentation.endpoint.UserResponse;

public class UserResponseFixture {

    private final UserResponse userResponse;

    private UserResponseFixture() {
        userResponse = new UserResponse();
        userResponse.id = "1";
        userResponse.firstName = "Name";
        userResponse.lastName = "Last Name";
        userResponse.username = "nlast";
        userResponse.office = "Belo Horizonte";
    }

    public static UserResponseFixture anUserResponse() {
        return new UserResponseFixture();
    }

    public UserResponse build() {
        return userResponse;
    }

}
