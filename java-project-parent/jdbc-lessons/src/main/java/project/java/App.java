package project.java;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        String sql = "update info set data = 'Test' where id=5;";
        try (Connection connection = ConnectionManager.getConnection();
             var statement = connection.createStatement()) {
            int count = statement.executeUpdate(sql);
            System.out.println(count);//false (нет селектов)
            System.out.println(statement.getUpdateCount());//количество вставленных страниц
        }

    }
}
