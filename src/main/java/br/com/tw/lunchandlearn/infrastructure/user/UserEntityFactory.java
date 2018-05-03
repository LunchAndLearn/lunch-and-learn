package br.com.tw.lunchandlearn.infrastructure.user;

import br.com.tw.lunchandlearn.domain.user.User;
import br.com.tw.lunchandlearn.infrastructure.office.OfficeEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityFactory {

    public UserEntity fromUser(User user) {
        OfficeEntity office = new OfficeEntity();
        office.name = user.getOffice().getName();

        UserEntity userEntity = new UserEntity();
        userEntity.id = user.getId();
        userEntity.firstName = user.getName();
        userEntity.lastName = user.getLastName();
        userEntity.userName = user.getTwUser();
        userEntity.password = user.getPassword().getValue();
        userEntity.office = office;

        return userEntity;
    }

}
