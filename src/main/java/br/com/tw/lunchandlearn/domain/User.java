package br.com.tw.lunchandlearn.domain;

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
