package project.java;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        String sql = "CREATE DATABASE game;";
        try (Connection connection = ConnectionManager.getConnection();
             var statement = connection.createStatement()) {
            boolean flag = statement.execute(sql);
            System.out.println(flag);
            System.out.println(connection.getTransactionIsolation());
        }

    }
}
