package br.com.tw.lunchandlearn.endpoint;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AuthenticationTest {

    @Test
    public void shouldLoginWithSuccess() {
        Authentication authentication = new Authentication();

        String username = "fulano123";
        String password = "fulanocomfome";
        ResponseEntity<UserResponse> userResponse =  authentication.login(new CredentialsRequest(username, password));

        assertThat(userResponse.getStatusCode(), is(HttpStatus.OK));
        assertThat(userResponse.getBody().firstName, is("Fulano"));
        assertThat(userResponse.getBody().lastName, is("Ciclano"));
        assertThat(userResponse.getBody().username, is("fulano123"));
    }

}