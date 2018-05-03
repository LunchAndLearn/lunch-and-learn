package br.com.tw.lunchandlearn.domain.user;

import br.com.tw.lunchandlearn.fixture.user.UserEntityFixture;
import br.com.tw.lunchandlearn.fixture.user.UserFixture;
import br.com.tw.lunchandlearn.fixture.user.UserRequestFixture;
import br.com.tw.lunchandlearn.infrastructure.user.UserEntity;
import br.com.tw.lunchandlearn.presentation.request.UserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UserFactoryTest {

    @InjectMocks
    private UserFactory userFactory;

    @Test
    public void createsUserFromAnUserEntity() {
        User expectedUser = UserFixture.anUser()
                .build();

        UserEntity userEntity = UserEntityFixture.anUserFixture()
                .build();

        User actualUser = userFactory.fromUserEntity(userEntity);

        assertThat(actualUser.getId()).isEqualTo(expectedUser.getId());
        assertThat(actualUser.getName()).isEqualTo(expectedUser.getName());
        assertThat(actualUser.getLastName()).isEqualTo(expectedUser.getLastName());
        assertThat(actualUser.getTwUser()).isEqualTo(expectedUser.getTwUser());
        assertThat(actualUser.getPassword().getValue()).isEqualTo(expectedUser.getPassword().getValue());
        assertThat(actualUser.getOffice().getName()).isEqualTo(expectedUser.getOffice().getName());
    }

    @Test
    public void createsUsersFromUsersEntities() {
        UserEntity userEntity = UserEntityFixture.anUserFixture()
                .build();

        List<User> users = userFactory.fromUserEntities(asList(userEntity));

        assertThat(users).hasSize(1);
    }

    @Test
    public void createsUserFromUserRequest() {
        User expectedUser = UserFixture.anUser()
                .withId(null)
                .build();

        UserRequest userRequest = UserRequestFixture.anUserRequest()
                .build();

        User actualUser = userFactory.fromUserRequest(userRequest);

        assertThat(actualUser.getId()).isEqualTo(expectedUser.getId());
        assertThat(actualUser.getName()).isEqualTo(expectedUser.getName());
        assertThat(actualUser.getLastName()).isEqualTo(expectedUser.getLastName());
        assertThat(actualUser.getTwUser()).isEqualTo(expectedUser.getTwUser());
        assertThat(actualUser.getPassword().getValue()).isEqualTo(expectedUser.getPassword().getValue());
        assertThat(actualUser.getOffice().getName()).isEqualTo(expectedUser.getOffice().getName());
    }

}