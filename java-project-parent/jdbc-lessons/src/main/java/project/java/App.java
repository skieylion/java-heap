package project.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from ticket";
        try (Connection connection = ConnectionManager.getConnection();
             var statement = connection.createStatement()) {
            ResultSet executeResult = statement.executeQuery(sql);
            while (executeResult.next()) {
                System.out.println(executeResult.getLong("id"));
            }
        }
    }
}
