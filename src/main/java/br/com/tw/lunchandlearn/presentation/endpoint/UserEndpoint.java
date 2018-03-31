package br.com.tw.lunchandlearn.presentation.endpoint;

import br.com.tw.lunchandlearn.domain.user.User;
import br.com.tw.lunchandlearn.domain.user.UserFactory;
import br.com.tw.lunchandlearn.infrastructure.user.UserEntity;
import br.com.tw.lunchandlearn.infrastructure.user.UserEntityFactory;
import br.com.tw.lunchandlearn.infrastructure.user.UserRepository;
import br.com.tw.lunchandlearn.presentation.request.UserRequest;
import br.com.tw.lunchandlearn.presentation.response.UserResponse;
import br.com.tw.lunchandlearn.presentation.response.UserResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserEndpoint {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserResponseFactory userResponseFactory;

    @Autowired
    private UserFactory userFactory;

    @Autowired
    private UserEntityFactory userEntityFactory;

    @RequestMapping(name = "/users", method = GET)
    public List<UserResponse> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();

        List<User> users = userFactory.fromUserEntities(userEntities);

        return userResponseFactory.fromUsers(users);
    }

    @RequestMapping(name = "/users", method = POST, produces = {"application/json"})
    public UserResponse createUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userFactory.fromUserRequest(userRequest);

        UserEntity userEntityToSave = userEntityFactory.fromUser(user);
        UserEntity savedUser = userRepository.save(userEntityToSave);

        user = userFactory.fromUserEntity(savedUser);

        return userResponseFactory.fromUser(user);
    }

}
