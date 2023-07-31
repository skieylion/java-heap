package project.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";
    private static final String URL = "jdbc:postgresql://localhost:5434/testdb";

    private ConnectionManager() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
