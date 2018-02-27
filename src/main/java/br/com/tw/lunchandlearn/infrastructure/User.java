package br.com.tw.lunchandlearn.infrastructure;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    public String id;
    public String name;

    public User(String name) {
        this.name = name;
    }
}
