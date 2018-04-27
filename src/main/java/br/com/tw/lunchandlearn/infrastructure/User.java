package br.com.tw.lunchandlearn.infrastructure;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    public String id;
    public String name;
    public String username;

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }
}
