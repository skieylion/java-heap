package project.java;

import org.postgresql.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String username = "test";
        String password = "test";
        String url = "jdbc:postgresql://localhost:5434/testdb";
        try (var connection = DriverManager.getConnection(url, username, password)) {
            System.out.println(connection.getTransactionIsolation());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
