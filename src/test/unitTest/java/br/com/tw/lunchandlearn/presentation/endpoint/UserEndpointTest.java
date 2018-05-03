package br.com.tw.lunchandlearn.presentation.endpoint;

import br.com.tw.lunchandlearn.domain.user.User;
import br.com.tw.lunchandlearn.domain.user.UserFactory;
import br.com.tw.lunchandlearn.infrastructure.user.UserEntity;
import br.com.tw.lunchandlearn.infrastructure.user.UserEntityFactory;
import br.com.tw.lunchandlearn.infrastructure.user.UserRepository;
import br.com.tw.lunchandlearn.presentation.request.UserRequest;
import br.com.tw.lunchandlearn.presentation.response.UserResponse;
import br.com.tw.lunchandlearn.presentation.response.UserResponseFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserEndpointTest {

    @InjectMocks
    private UserEndpoint userEndpoint;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserFactory userFactory;

    @Mock
    private UserResponseFactory userResponseFactory;

    @Mock
    private UserEntityFactory userEntityFactory;

    @Test
    public void findsAllUsers() {
        List<UserEntity> userEntities = asList(mock(UserEntity.class));
        List<User> users = asList(mock(User.class));
        List<UserResponse> userResponses = asList(mock(UserResponse.class));

        when(userRepository.findAll()).thenReturn(userEntities);
        when(userFactory.fromUserEntities(userEntities)).thenReturn(users);
        when(userResponseFactory.fromUsers(users)).thenReturn(userResponses);

        List<UserResponse> actualUsers = userEndpoint.findAll();

        assertThat(actualUsers).hasSize(1);
    }

    @Test
    public void createUser() {
        User user = mock(User.class);
        UserRequest userRequest = mock(UserRequest.class);
        UserEntity userEntity = mock(UserEntity.class);
        User savedUser = mock(User.class);

        UserResponse expectedUserResponse = new UserResponse();
        expectedUserResponse.name = "name";

        when(userFactory.fromUserRequest(userRequest)).thenReturn(user);
        when(userEntityFactory.fromUser(user)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);

        when(userFactory.fromUserEntity(userEntity)).thenReturn(savedUser);
        when(userResponseFactory.fromUser(savedUser)).thenReturn(expectedUserResponse);

        UserResponse actualUserResponse = userEndpoint.createUser(userRequest);

        assertThat(actualUserResponse.name).isEqualTo(expectedUserResponse.name);
    }

}