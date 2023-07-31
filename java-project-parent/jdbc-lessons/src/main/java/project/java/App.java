package project.java;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection()) {
            System.out.println(connection.getTransactionIsolation());
        }

    }
}
