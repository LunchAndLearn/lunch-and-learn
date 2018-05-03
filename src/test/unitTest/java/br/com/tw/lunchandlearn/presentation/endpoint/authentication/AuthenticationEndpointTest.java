package br.com.tw.lunchandlearn.presentation.endpoint.authentication;

import br.com.tw.lunchandlearn.domain.authentication.AuthenticationException;
import br.com.tw.lunchandlearn.domain.authentication.AuthenticationService;
import br.com.tw.lunchandlearn.presentation.endpoint.UserResponse;
import br.com.tw.lunchandlearn.domain.base.exception.ApiException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationEndpointTest {

    private static final String ENCRYPTED_PASSWORD = "$2a$10$dDWf0kiLKrsoFr89QKOoeeySRFAaLtMs3rTJCc1d8CFEekU8TCcg2";
    private static final String USERNAME = "fulano123";
    private static final String VALID_PASSWORD = "fulanocomfome";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthenticationEndpoint authenticationEndpoint;

    private CredentialsRequest credentialsRequest;

    @Before
    public void setUp() {
        credentialsRequest = new CredentialsRequest();
        credentialsRequest.username = USERNAME;
        credentialsRequest.password = VALID_PASSWORD;

        when(passwordEncoder.matches(VALID_PASSWORD, ENCRYPTED_PASSWORD)).thenReturn(true);
    }

    @Test
    public void shouldCallPasswordEncoderMatches() {
        authenticationEndpoint.login(credentialsRequest);

        verify(passwordEncoder).matches(VALID_PASSWORD, ENCRYPTED_PASSWORD);
    }

    @Test
    public void shouldLoginWithSuccess() {
        ResponseEntity<UserResponse> userResponse =  authenticationEndpoint.login(credentialsRequest);

        assertThat(userResponse.getStatusCode(), is(HttpStatus.OK));
        assertThat(userResponse.getBody().firstName, is("Fulano"));
        assertThat(userResponse.getBody().lastName, is("Ciclano"));
        assertThat(userResponse.getBody().username, is("fulano123"));
        assertThat(userResponse.getBody().office, is("Belzonte"));
    }

    @Test
    public void throwsExceptionWhenLoginFailWithWrongPassword() {
        expectedException.expect(ApiException.class);
        expectedException.expectMessage("Your credentials are invalid.");

        credentialsRequest.password = "fulanosatisfeito";
        authenticationEndpoint.login(credentialsRequest);
    }

    @Test
    public void throwsExceptionWhenLoginFailWithWrongUsername() {
        expectedException.expect(ApiException.class);
        expectedException.expectMessage("Your credentials are invalid.");

        credentialsRequest.username = "fulano678";
        authenticationEndpoint.login(credentialsRequest);
    }

    @Test
    public void callsAuthenticationServicePassingCredentialsRequest() {
        authenticationEndpoint.loginWithService(credentialsRequest);

        verify(authenticationService).authenticate(credentialsRequest);
    }

    @Test
    public void returnsHttpStatusOKWhenCredentialsAreValid() {
        when(authenticationService.authenticate(credentialsRequest)).thenReturn(new UserResponse());

        ResponseEntity responseEntity = authenticationEndpoint.loginWithService(credentialsRequest);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    }

    @Test(expected = AuthenticationException.class)
    public void throwsAuthenticationExceptionWhenCredentialsAreInvalid() {
        when(authenticationService.authenticate(credentialsRequest)).thenThrow(new AuthenticationException());

        authenticationEndpoint.loginWithService(credentialsRequest);
    }

    @Test
    public void returnsUserResponseWhenCredentialsAreValid() {
        UserResponse userResponse = new UserResponse();
        when(authenticationService.authenticate(credentialsRequest)).thenReturn(userResponse);

        ResponseEntity<UserResponse> responseEntity = authenticationEndpoint.loginWithService(credentialsRequest);

        assertThat(responseEntity.getBody(), is(userResponse));
    }
}