package org.app.Database;

import lombok.Getter;
import lombok.Setter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
public class DbConfig {
    private String url;
    private String userName;
    private String password;
    PostgresConfig postgresConfig = new PostgresConfig();

    public DbConfig() {
        this.url = postgresConfig.getURL();
        this.userName = postgresConfig.getUSERNAME();
        this.password = postgresConfig.getPASSWORD();
    }

    public Connection createConnection() {
        try {
            Connection connection = DriverManager.getConnection(
                    this.url, this.userName, this.password
            );
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
