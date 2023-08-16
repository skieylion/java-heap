package project.java;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        printFlightBetweenDates(LocalDateTime.of(2019, 1, 1, 1, 1),
                LocalDateTime.now());
    }


    static void printFlightById(Long id) throws SQLException {
        String sql = "select * from flight where id=?";
        try (Connection connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet1 = preparedStatement.executeQuery();
            while (resultSet1.next()) {
                Long currentId = resultSet1.getObject("id", Long.class);
                String status = resultSet1.getString("status");
                Timestamp ts = resultSet1.getTimestamp("arrival_date");
                var localDateTime = LocalDateTime.ofInstant(ts.toInstant(), ZoneId.systemDefault());
                System.out.printf("flight (%d) - %s : %tF %n", currentId, status, localDateTime);
            }
        }
    }

    static void printFlightBetweenDates(LocalDateTime start, LocalDateTime end) throws SQLException {
        String sql = "select * from flight where arrival_date between ? and ?";
        try (Connection connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setFetchSize(1);//размер запрашиваемых данных в 50 строк
            preparedStatement.setQueryTimeout(5);//ожидание запроса 10 секунд
            preparedStatement.setMaxRows(3);//максимальное количество строк
            preparedStatement.setTimestamp(1, Timestamp.from(start.toInstant(ZoneOffset.UTC)));
            preparedStatement.setTimestamp(2, Timestamp.from(end.toInstant(ZoneOffset.UTC)));
            ResultSet resultSet1 = preparedStatement.executeQuery();
            while (resultSet1.next()) {
                Long currentId = resultSet1.getObject("id", Long.class);
                String status = resultSet1.getString("status");
                Timestamp ts = resultSet1.getTimestamp("arrival_date");
                var localDateTime = LocalDateTime.ofInstant(ts.toInstant(), ZoneId.systemDefault());
                System.out.printf("flight (%d) - %s : %tF %n", currentId, status, localDateTime);
            }
        }
    }
}
