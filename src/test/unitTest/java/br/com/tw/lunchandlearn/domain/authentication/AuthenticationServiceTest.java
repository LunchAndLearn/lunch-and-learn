package br.com.tw.lunchandlearn.domain.authentication;

import br.com.tw.lunchandlearn.infrastructure.User;
import br.com.tw.lunchandlearn.infrastructure.UserRepository;
import br.com.tw.lunchandlearn.presentation.endpoint.UserResponse;
import br.com.tw.lunchandlearn.presentation.endpoint.authentication.CredentialsRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthenticationService authenticationService;

    private CredentialsRequest credentialsRequest;

    @Before
    public void setUp() {
        credentialsRequest = new CredentialsRequest();
        credentialsRequest.username = "anyusername";
    }

    @Test
    public void searchesByUsernameInRepository() {
        User user = new User("first name", "username");
        when(userRepository.findByUsername("anyusername")).thenReturn(user);

        authenticationService.authenticate(credentialsRequest);

        verify(userRepository).findByUsername("anyusername");
    }

    @Test
    public void returnsUserResponseWhenAuthenticateUser() {
        User user = new User("first name", "username");
        when(userRepository.findByUsername("anyusername")).thenReturn(user);

        UserResponse authenticatedUser = authenticationService.authenticate(credentialsRequest);

        assertThat(authenticatedUser.firstName).isEqualTo("first name");
    }

}