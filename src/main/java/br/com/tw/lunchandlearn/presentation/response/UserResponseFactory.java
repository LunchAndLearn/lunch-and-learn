package br.com.tw.lunchandlearn.presentation.response;

import br.com.tw.lunchandlearn.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserResponseFactory {

    public UserResponse fromUser(User user) {
        UserResponse.Office office = new UserResponse.Office();
        office.name = user.getOffice().getName();

        UserResponse userResponse = new UserResponse();
        userResponse.id = user.getId();
        userResponse.name = user.getName();
        userResponse.lastName = user.getLastName();
        userResponse.user = user.getTwUser();
        userResponse.password = user.getPassword().getValue();
        userResponse.office = office;

        return userResponse;
    }

    public List<UserResponse> fromUsers(List<User> users) {
        return null;
    }

}
