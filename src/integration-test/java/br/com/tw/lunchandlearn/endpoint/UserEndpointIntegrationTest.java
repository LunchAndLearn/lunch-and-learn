package br.com.tw.lunchandlearn.endpoint;

import br.com.tw.lunchandlearn.infrastructure.User;
import br.com.tw.lunchandlearn.infrastructure.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEndpointIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void callsUserEndpoint() throws Exception {
        User user = new User("User");
        userRepository.save(user);

        List<User> allUsers = userRepository.findAll();

        assertThat(allUsers.size(), is(1));
    }

    @After
    public void tearDown() throws Exception {
        userRepository.deleteAll();
    }

}