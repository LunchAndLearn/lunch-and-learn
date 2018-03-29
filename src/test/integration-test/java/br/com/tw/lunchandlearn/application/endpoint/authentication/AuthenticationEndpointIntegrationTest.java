package br.com.tw.lunchandlearn.application.endpoint.authentication;

import br.com.tw.lunchandlearn.application.endpoint.UserResponse;
import br.com.tw.lunchandlearn.application.endpoint.authentication.CredentialsRequest;
import br.com.tw.lunchandlearn.domain.exception.ApiExceptionCode;
import br.com.tw.lunchandlearn.application.handler.ApiExceptionResponse;
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
public class AuthenticationEndpointIntegrationTest {

    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Autowired
    private Environment environment;

    @Test
    public void loginUserWithSuccess() {
        String port = environment.getProperty("local.server.port");
        CredentialsRequest credentialRequest = new CredentialsRequest();
        credentialRequest.username = "fulano123";
        credentialRequest.password = "fulanocomfome";

        ResponseEntity<UserResponse> response = testRestTemplate.postForEntity("http://localhost:" + port + "/login", credentialRequest, UserResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().firstName, is("Fulano"));
        assertThat(response.getBody().lastName, is("Ciclano"));
        assertThat(response.getBody().username, is("fulano123"));
    }

    @Test
    public void failLoginWhenCredentialsAreInvalid() {
        String port = environment.getProperty("local.server.port");
        CredentialsRequest credentialRequest = new CredentialsRequest();
        credentialRequest.username = "fulano123";
        credentialRequest.password = "fulanosemfome";

        ResponseEntity<ApiExceptionResponse> response = testRestTemplate.postForEntity("http://localhost:" + port + "/login", credentialRequest, ApiExceptionResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
        assertThat(response.getBody().code, is(ApiExceptionCode.INVALID_CREDENTIALS.getCode()));
        assertThat(response.getBody().message, is("Your credentials are invalid."));
    }
}