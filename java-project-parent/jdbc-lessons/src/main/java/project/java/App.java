package project.java;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        String sql = "";
        try (Connection connection = ConnectionManager.getConnection();
             var statement = connection.createStatement()) {
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            System.out.println(statement.getUpdateCount());
        }
    }
}
