package br.com.tw.lunchandlearn.infrastructure.user;

import br.com.tw.lunchandlearn.domain.user.User;
import br.com.tw.lunchandlearn.fixture.user.UserFixture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UserEntityFactoryTest {

    @InjectMocks
    private UserEntityFactory userEntityFactory;

    @Test
    public void createAnUserEntityFromAnUser() {
        User user = UserFixture.anUser()
                .withId(null)
                .build();

        UserEntity actualUserEntity = userEntityFactory.fromUser(user);

        assertThat(actualUserEntity.id).isEqualTo(null);
        assertThat(actualUserEntity.firstName).isEqualTo(user.getName());
        assertThat(actualUserEntity.lastName).isEqualTo(user.getLastName());
        assertThat(actualUserEntity.userName).isEqualTo(user.getTwUser());
        assertThat(actualUserEntity.password).isEqualTo(user.getPassword().getValue());
        assertThat(actualUserEntity.office.name).isEqualTo(user.getOffice().getName());
    }

}