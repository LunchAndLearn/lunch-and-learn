package br.com.tw.lunchandlearn.presentation.response;

import br.com.tw.lunchandlearn.domain.user.User;
import br.com.tw.lunchandlearn.presentation.endpoint.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class UserResponseFactory {

    public UserResponse fromUser(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.id = user.getId();
        userResponse.firstName = user.getName();
        userResponse.lastName = user.getLastName();
        userResponse.username = user.getTwUser();
        userResponse.office = user.getOffice().getName();

        return userResponse;
    }

    public List<UserResponse> fromUsers(List<User> users) {
        return users.stream()
                .map(this::fromUser)
                .collect(toList());
    }

}
