package org.app.Service;

import org.app.Database.DbConfig;
import org.app.Model.Player;
import org.app.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class LoginService {

    public Player saveUser(Player player) {
        DbConfig dbConfig = new DbConfig();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO player (name, last_name, password) VALUES (?, ?, ?)";

        try {
            connection = dbConfig.createConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, player.getName());
            preparedStatement.setString(2, player.getLastName());
            preparedStatement.setString(3, player.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return player;
    }

    public List<Player> showAllUsers() throws SQLException {
        DbConfig db = new DbConfig();
        Connection connection = db.createConnection();
        List<Player> allPlayers = new ArrayList<>();
        String sql = "SELECT * FROM player ORDER BY name ASC";

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                allPlayers.add(new Player(
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("password")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return allPlayers;
    }
}