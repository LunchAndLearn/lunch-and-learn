package br.com.tw.lunchandlearn.endpoint;

import br.com.tw.lunchandlearn.presentation.endpoint.Authentication;
import br.com.tw.lunchandlearn.presentation.request.CredentialsRequest;
import br.com.tw.lunchandlearn.presentation.response.UserResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationTest {

    private static final String ENCRYPTED_PASSWORD = "$2a$10$dDWf0kiLKrsoFr89QKOoeeySRFAaLtMs3rTJCc1d8CFEekU8TCcg2";
    private static final String USERNAME = "fulano123";
    private static final String VALID_PASSWORD = "fulanocomfome";

    private CredentialsRequest credentialsRequest;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private Authentication authentication;

    @Before
    public void setUp() {
        credentialsRequest = new CredentialsRequest();
        credentialsRequest.username = USERNAME;
        credentialsRequest.password = VALID_PASSWORD;

        when(passwordEncoder.matches(VALID_PASSWORD, ENCRYPTED_PASSWORD)).thenReturn(true);
    }

    @Test
    public void shouldCallPasswordEncoderMatches() {
        authentication.login(credentialsRequest);

        verify(passwordEncoder).matches(VALID_PASSWORD, ENCRYPTED_PASSWORD);
    }

    @Test
    public void shouldLoginWithSuccess() {
        ResponseEntity<UserResponse> userResponse =  authentication.login(credentialsRequest);

        assertThat(userResponse.getStatusCode(), is(HttpStatus.OK));
        assertThat(userResponse.getBody().name, is("Fulano"));
        assertThat(userResponse.getBody().lastName, is("Ciclano"));
        assertThat(userResponse.getBody().user, is("fulano123"));
        assertThat(userResponse.getBody().office.name, is("Belzonte"));
    }

    @Test
    public void shouldLoginFailWhenIsWrongPassword() {
        credentialsRequest.password = "fulanosatisfeito";
        ResponseEntity<UserResponse> userResponse =  authentication.login(credentialsRequest);

        assertThat(userResponse.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
        assertThat(userResponse.getBody(), is(nullValue()));
    }

    @Test
    public void shouldLoginFailWhenIsWrongUsername() {
        credentialsRequest.username = "fulano678";
        ResponseEntity<UserResponse> userResponse =  authentication.login(credentialsRequest);

        assertThat(userResponse.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
        assertThat(userResponse.getBody(), is(nullValue()));
    }
}