package br.com.tw.lunchandlearn.endpoint;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class AuthenticationTest {

    private CredentialsRequest credentialsRequest;

    @Before
    public void setUp() throws Exception {
        credentialsRequest = new CredentialsRequest();
        credentialsRequest.username = "fulano123";
        credentialsRequest.password = "fulanocomfome";
    }

    @Test
    public void shouldLoginWithSuccess() {
        Authentication authentication = new Authentication();

        ResponseEntity<UserResponse> userResponse =  authentication.login(credentialsRequest);

        assertThat(userResponse.getStatusCode(), is(HttpStatus.OK));
        assertThat(userResponse.getBody().firstName, is("Fulano"));
        assertThat(userResponse.getBody().lastName, is("Ciclano"));
        assertThat(userResponse.getBody().username, is("fulano123"));
        assertThat(userResponse.getBody().office, is("Belzonte"));
    }

    @Test
    public void shouldLoginFailWhenIsWrongPassword() throws Exception {
        Authentication authentication = new Authentication();

        credentialsRequest.password = "fulanosatisfeito";
        ResponseEntity<UserResponse> userResponse =  authentication.login(credentialsRequest);

        assertThat(userResponse.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
        assertThat(userResponse.getBody(), is(nullValue()));
    }

    @Test
    public void shouldLoginFailWhenIsWrongUsername() throws Exception {
        Authentication authentication = new Authentication();

        credentialsRequest.username = "fulano678";
        ResponseEntity<UserResponse> userResponse =  authentication.login(credentialsRequest);

        assertThat(userResponse.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
        assertThat(userResponse.getBody(), is(nullValue()));
    }


}