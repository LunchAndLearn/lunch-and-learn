package br.com.tw.lunchandlearn.endpoint;

import br.com.tw.lunchandlearn.infrastructure.User;
import br.com.tw.lunchandlearn.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserEndpoint {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(name = "/users")
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
