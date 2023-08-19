package project.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class App {
    public static void main(String[] args) throws SQLException {
        executeTransaction();
    }

    static void executeTransaction() throws SQLException {
        Connection connection = null;
        PreparedStatement deleteFlightSql = null;
        PreparedStatement deleteTicketSql = null;
        try {
            connection = ConnectionManager.getConnection();
            connection.setAutoCommit(false);
            deleteFlightSql = connection.prepareStatement("delete from flight where id=9");
            deleteTicketSql = connection.prepareStatement("delete from ticket where flight_id=9");

            deleteTicketSql.executeUpdate();
            if (true) {
                throw new RuntimeException("some message");
            }
            deleteFlightSql.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (deleteFlightSql != null) {
                deleteFlightSql.close();
            }
            if (deleteTicketSql != null) {
                deleteTicketSql.close();
            }
        }
    }

    static void printMetaData() throws SQLException {
        try (Connection connection = ConnectionManager.getConnection()) {
            var metaData = connection.getMetaData();
            ResultSet catalogs = metaData.getCatalogs();
            while (catalogs.next()) {
                String catalogName = catalogs.getString("TABLE_CAT");
                System.out.printf("- '%s' %n", catalogName);
                ResultSet schemas = metaData.getSchemas();
                while (schemas.next()) {
                    String schemaName = schemas.getString("TABLE_SCHEM");
                    System.out.printf("-- '%s' %n", schemaName);
                    ResultSet tables = metaData.getTables(catalogName, schemaName, "%", null);
                    while (tables.next()) {
                        System.out.printf("---- '%s' %n", tables.getString("TABLE_NAME"));
                    }
                }
            }
        }
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
