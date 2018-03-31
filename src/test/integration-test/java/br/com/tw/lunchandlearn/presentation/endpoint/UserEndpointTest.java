package br.com.tw.lunchandlearn.presentation.endpoint;

import br.com.tw.lunchandlearn.fixture.user.UserRequestFixture;
import br.com.tw.lunchandlearn.infrastructure.user.UserRepository;
import br.com.tw.lunchandlearn.presentation.request.UserRequest;
import br.com.tw.lunchandlearn.presentation.response.UserResponse;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserEndpointTest {

    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Autowired
    private Environment environment;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUser() throws Exception {
        String port = environment.getProperty("local.server.port");

        UserRequest user = UserRequestFixture.anUserRequest()
                .build();

        ResponseEntity<UserResponse> response = testRestTemplate.postForEntity("http://localhost:" + port + "/users", user, UserResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().name, is(user.firstName));
    }

    @After
    public void tearDown() {
        userRepository.deleteAll();
    }

}