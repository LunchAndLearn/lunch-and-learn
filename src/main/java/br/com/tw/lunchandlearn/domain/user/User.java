package br.com.tw.lunchandlearn.domain.user;

import br.com.tw.lunchandlearn.domain.office.Office;

public class User {

    private String id;

    private String name;

    private String lastName;

    private String twUser;

    private Password password;

    private Office office;

    public User(String id, String name, String lastName, String twUser, Password password, Office office) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.twUser = twUser;
        this.password = password;
        this.office = office;
    }

    public User(String firstName, String lastName, String thoughtWorksUser, Password password, Office office) {
        this.name = firstName;
        this.lastName = lastName;
        this.twUser = thoughtWorksUser;
        this.password = password;
        this.office = office;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTwUser() {
        return twUser;
    }

    public Password getPassword() {
        return password;
    }

    public Office getOffice() {
        return office;
    }
}
