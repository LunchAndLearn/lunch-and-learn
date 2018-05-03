package br.com.tw.lunchandlearn.domain.authentication;

import br.com.tw.lunchandlearn.fixture.user.UserEntityFixture;
import br.com.tw.lunchandlearn.infrastructure.user.UserEntity;
import br.com.tw.lunchandlearn.infrastructure.user.UserRepository;
import br.com.tw.lunchandlearn.presentation.endpoint.UserResponse;
import br.com.tw.lunchandlearn.presentation.endpoint.authentication.CredentialsRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
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
        UserEntity user = UserEntityFixture.anUserFixture()
                .withName("first name")
                .withUser("username")
                .build();

        when(userRepository.findByUserName("anyusername")).thenReturn(user);

        authenticationService.authenticate(credentialsRequest);

        verify(userRepository).findByUserName("anyusername");
    }

    @Test
    public void returnsUserResponseWhenAuthenticateUser() {
        UserEntity user = UserEntityFixture.anUserFixture()
                .withName("first name")
                .withUser("username")
                .build();

        when(userRepository.findByUserName("anyusername")).thenReturn(user);

        UserResponse authenticatedUser = authenticationService.authenticate(credentialsRequest);

        assertThat(authenticatedUser.firstName).isEqualTo("first name");
    }

}