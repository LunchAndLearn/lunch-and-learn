package br.com.tw.lunchandlearn.domain.user;

import br.com.tw.lunchandlearn.domain.office.Office;
import br.com.tw.lunchandlearn.infrastructure.user.UserEntity;
import br.com.tw.lunchandlearn.presentation.request.UserRequest;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class UserFactory {

    public User fromUserEntity(UserEntity userEntity) {
        Password password = new Password(userEntity.password);
        Office office = new Office(userEntity.office.name);

        User user = new User(userEntity.id, userEntity.name, userEntity.lastName, userEntity.user, password, office);

        return user;
    }

    public List<User> fromUserEntities(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(this::fromUserEntity)
                .collect(toList());
    }

    public User fromUserRequest(UserRequest userRequest) {
        Password password = new Password(userRequest.password);
        Office office = new Office(userRequest.office.name);

        User user = new User(null, userRequest.firstName, userRequest.lastName, userRequest.thoughtWorksUser, password, office);

        return user;
    }

}
