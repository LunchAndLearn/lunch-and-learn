package br.com.tw.lunchandlearn.fixture.user;

import br.com.tw.lunchandlearn.presentation.request.UserRequest;

public class UserRequestFixture {

    private UserRequest userRequest;

    public UserRequestFixture() {
        UserRequest.Office office = new UserRequest.Office();
        office.name = "Belo Horizonte";

        userRequest = new UserRequest();
        userRequest.firstName = "Name";
        userRequest.lastName = "Last Name";
        userRequest.thoughtWorksUser = "nlast";
        userRequest.password = "123";
        userRequest.office = office;
    }

    public static UserRequestFixture anUserRequest() {
        return new UserRequestFixture();
    }

    public UserRequest build() {
        return userRequest;
    }

}
