package br.com.tw.lunchandlearn.endpoint;

public class CredentialsRequest {
    public String username;
    public String password;

    public CredentialsRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public CredentialsRequest() {

    }
}
