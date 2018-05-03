package br.com.tw.lunchandlearn.presentation.response;

import br.com.tw.lunchandlearn.domain.user.User;
import br.com.tw.lunchandlearn.fixture.user.UserFixture;
import br.com.tw.lunchandlearn.fixture.user.UserResponseFixture;
import br.com.tw.lunchandlearn.presentation.endpoint.UserResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UserResponseFactoryTest {

    @InjectMocks
    private UserResponseFactory userResponseFactory;

    @Test
    public void createAValidUserResponseFromUser() {
        User user = UserFixture.anUser()
                .build();

        UserResponse expectedUserResponse = UserResponseFixture.anUserResponse()
                .build();

        UserResponse actualUserResponse = userResponseFactory.fromUser(user);

        assertThat(actualUserResponse.id).isEqualTo(expectedUserResponse.id);
        assertThat(actualUserResponse.firstName).isEqualTo(expectedUserResponse.firstName);
        assertThat(actualUserResponse.lastName).isEqualTo(expectedUserResponse.lastName);
        assertThat(actualUserResponse.username).isEqualTo(expectedUserResponse.username);
        assertThat(actualUserResponse.office).isEqualTo(expectedUserResponse.office);
    }

    @Test
    public void createUserResponsesFromUsers() throws Exception {
        User user = UserFixture.anUser()
                .build();

        List<UserResponse> actualUserResponses = userResponseFactory.fromUsers(asList(user));

        assertThat(actualUserResponses).hasSize(1);
    }

}