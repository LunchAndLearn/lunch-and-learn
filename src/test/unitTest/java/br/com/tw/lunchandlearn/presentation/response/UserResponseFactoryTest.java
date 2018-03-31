package br.com.tw.lunchandlearn.presentation.response;

import br.com.tw.lunchandlearn.domain.user.User;
import br.com.tw.lunchandlearn.fixture.user.UserFixture;
import br.com.tw.lunchandlearn.fixture.user.UserResponseFixture;
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
        assertThat(actualUserResponse.name).isEqualTo(expectedUserResponse.name);
        assertThat(actualUserResponse.lastName).isEqualTo(expectedUserResponse.lastName);
        assertThat(actualUserResponse.user).isEqualTo(expectedUserResponse.user);
        assertThat(actualUserResponse.password).isEqualTo(expectedUserResponse.password);
        assertThat(actualUserResponse.office.name).isEqualTo(expectedUserResponse.office.name);
    }

    @Test
    public void createUserResponsesFromUsers() throws Exception {
        User user = UserFixture.anUser()
                .build();

        List<UserResponse> actualUserResponses = userResponseFactory.fromUsers(asList(user));

        assertThat(actualUserResponses.size()).isEqualTo(1);
    }

}