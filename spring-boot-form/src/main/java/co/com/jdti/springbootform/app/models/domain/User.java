package co.com.jdti.springbootform.app.models.domain;

import javax.validation.constraints.NotEmpty;

public class User {

    @NotEmpty(message = "Can´t be empty")
    private String name;

    @NotEmpty(message = "Can´t be empty")
    private String lastName;

    @NotEmpty(message = "Can´t be empty")
    private String username;

    @NotEmpty(message = "Can´t be empty")
    private String password;

    @NotEmpty(message = "Can´t be empty")
    private String email;

    public User() {
    }

    public User(String name, String lastName, String username, String password, String email) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
