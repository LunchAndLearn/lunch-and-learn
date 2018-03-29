package br.com.tw.lunchandlearn.fixture;

import br.com.tw.lunchandlearn.presentation.response.UserResponse;

public class UserResponseFixture {

    private final UserResponse userResponse;

    private UserResponseFixture() {
        UserResponse.Office office = new UserResponse.Office();
        office.name = "Belo Horizonte";

        userResponse = new UserResponse();
        userResponse.id = "1";
        userResponse.name = "Name";
        userResponse.lastName = "Last Name";
        userResponse.user = "nlast";
        userResponse.password = "123";
        userResponse.office = office;
    }

    public static UserResponseFixture anUserResponse() {
        return new UserResponseFixture();
    }

    public UserResponse build() {
        return userResponse;
    }

}
