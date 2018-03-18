package br.com.tw.lunchandlearn.presentation.endpoint;

import br.com.tw.lunchandlearn.infrastructure.User;
import br.com.tw.lunchandlearn.infrastructure.UserRepository;
import br.com.tw.lunchandlearn.presentation.request.UserRequest;
import br.com.tw.lunchandlearn.presentation.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserEndpoint {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(name = "/users")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @RequestMapping(name = "/users", method = POST, produces = {"application/json"})
    public UserResponse createUser(@Valid @RequestBody UserRequest userRequest) {

        return new UserResponse();
    }

}
