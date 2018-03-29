package br.com.tw.lunchandlearn.fixture.user;

import br.com.tw.lunchandlearn.domain.user.Password;

public class PasswordFixture {

    private String value;

    private PasswordFixture() {
        this.value = "123";
    }

    public static PasswordFixture aPassword() {
        return new PasswordFixture();
    }

    public PasswordFixture withValue(String value) {
        this.value = value;
        return this;
    }

    public Password build() {
        return new Password(value);
    }

}
