package br.com.tw.lunchandlearn.fixture;

import br.com.tw.lunchandlearn.infrastructure.user.UserEntity;

public class UserEntityFixture {

    private UserEntity userEntity;

    private UserEntityFixture() {
        userEntity = new UserEntity();

        userEntity.id = "1";
        userEntity.name = "Name";
        userEntity.lastName = "Last Name";
        userEntity.user = "nlast";
        userEntity.password = "123";
        userEntity.office = OfficeEntityFixture.anOffice()
                .build();
    }

    public static UserEntityFixture anUserFixture() {
        return new UserEntityFixture();
    }

    public UserEntity build() {
        return userEntity;
    }

}
