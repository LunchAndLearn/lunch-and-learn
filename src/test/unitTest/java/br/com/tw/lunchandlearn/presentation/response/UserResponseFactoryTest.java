package br.com.tw.lunchandlearn.presentation.response;

import br.com.tw.lunchandlearn.domain.User;
import br.com.tw.lunchandlearn.fixture.UserFixture;
import br.com.tw.lunchandlearn.fixture.UserResponseFixture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

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

}