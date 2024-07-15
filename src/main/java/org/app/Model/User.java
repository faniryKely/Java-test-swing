package org.app.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
