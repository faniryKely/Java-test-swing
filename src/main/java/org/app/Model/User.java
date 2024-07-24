package org.app.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {
    private UUID userId;
    private String name;
    private String lastName;
    private String email;
    private String password;


    public User(String id, String name, String lastName, String email, String password) {
        this.userId = UUID.fromString(id);
        this.name =  name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    public User(String name, String lastName, String email, String password) {
        this.name =  name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
