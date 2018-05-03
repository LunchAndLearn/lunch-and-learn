package br.com.tw.lunchandlearn.fixture.user;

import br.com.tw.lunchandlearn.fixture.office.OfficeEntityFixture;
import br.com.tw.lunchandlearn.infrastructure.user.UserEntity;

public class UserEntityFixture {

    private UserEntity userEntity;

    private UserEntityFixture() {
        userEntity = new UserEntity();

        userEntity.id = "1";
        userEntity.firstName = "Name";
        userEntity.lastName = "Last Name";
        userEntity.userName = "nlast";
        userEntity.password = "123";
        userEntity.office = OfficeEntityFixture.anOffice()
                .build();
    }

    public static UserEntityFixture anUserFixture() {
        return new UserEntityFixture();
    }

    public UserEntityFixture withName(String name) {
        userEntity.firstName = name;
        return this;
    }

    public UserEntityFixture withUser(String username) {
        userEntity.userName = username;
        return this;
    }

    public UserEntity build() {
        return userEntity;
    }

}
