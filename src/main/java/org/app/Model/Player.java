package org.app.Model;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.UUID;
@Getter
@Setter
public class Player extends JFrame {
    private UUID playerId;
    private String name;
    private String lastName;
    private String password;

    public Player(UUID playerId, String name, String lastName, String password) {
        this.playerId = playerId;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }
    public Player(String name, String lastName, String password) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }
}
