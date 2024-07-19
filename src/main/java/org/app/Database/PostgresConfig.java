package org.app.Database;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostgresConfig {
    private final String URL = "jdbc:postgresql://localhost:5432/swingtest";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "faniry@2002";
}
