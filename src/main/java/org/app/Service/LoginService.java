package org.app.Service;

import org.app.Database.DbConfig;
import org.app.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginService {

    public User SaveUser(User user) {
        DbConfig dbConfig = new DbConfig();
        Connection connection = dbConfig.createConnection();

        String sql = "INSERT INTO \"user\" (name, last_name, email, password) VALUES (name = ?, last_name = ?, email = ?, password = ? )";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();


            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return user;
    }
}