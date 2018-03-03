package br.com.tw.lunchandlearn.infrastructure;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void countUsers() {
        long count = userRepository.count();

        assertThat(count, is(0L));
    }

    @Test
    public void createUser() {
        User user = new User("New User Name");

        User userSaved = userRepository.save(user);

        assertThat(userSaved.id, is(not(nullValue())));
    }

    @Test
    public void findUserByName() {
        User user = new User("New User Name");
        userRepository.save(user);

        User userFound = userRepository.findByName("New User Name");

        assertThat(userFound.id, is(not(nullValue())));
        assertThat(userFound.name, is("New User Name"));
    }

    @After
    public void tearDown() {
        userRepository.deleteAll();
    }

}