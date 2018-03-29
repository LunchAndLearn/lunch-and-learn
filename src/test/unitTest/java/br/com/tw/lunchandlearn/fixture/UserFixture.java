package br.com.tw.lunchandlearn.fixture;

import br.com.tw.lunchandlearn.domain.Office;
import br.com.tw.lunchandlearn.domain.Password;
import br.com.tw.lunchandlearn.domain.User;

public class UserFixture {

    private String id;
    private String name;
    private String lastName;
    private String twUser;
    private Password password;
    private Office office;

    private UserFixture() {
        this.id = "1";
        this.name = "Name";
        this.lastName = "Last Name";
        this.twUser = "nlast";
        this.password = PasswordFixture.aPassword()
                .build();
        this.office = OfficeFixture.anOffice()
                .build();
    }

    public static UserFixture anUser() {
        return new UserFixture();
    }

    public UserFixture withId(String id) {
        this.id = id;
        return this;
    }

    public UserFixture withName(String name) {
        this.name = name;
        return this;
    }

    public UserFixture withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserFixture withTwUser(String twUser) {
        this.twUser = twUser;
        return this;
    }

    public UserFixture withPassword(Password password) {
        this.password = password;
        return this;
    }

    public UserFixture withOffice(Office office) {
        this.office = office;
        return this;
    }

    public User build() {
        return new User(id, name, lastName, twUser, password, office);
    }

}
