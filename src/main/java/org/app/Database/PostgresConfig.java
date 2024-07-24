package org.app.Database;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostgresConfig {
    private final String URL = System.getenv("DB_URL");
    private final String USERNAME = System.getenv("DB_USERNAME");
    private final String PASSWORD = System.getenv("DB_PASSWORD");
}
