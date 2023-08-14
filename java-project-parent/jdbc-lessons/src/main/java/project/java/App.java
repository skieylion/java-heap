package project.java;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        String sql = "CREATE SCHEMA game_schema;";
        try (Connection connection = ConnectionManager.getConnection();
             var statement = connection.createStatement()) {
            boolean flag = statement.execute(sql);
            System.out.println(flag);//false (нет селектов)
            System.out.println(connection.getTransactionIsolation());
        }

    }
}
