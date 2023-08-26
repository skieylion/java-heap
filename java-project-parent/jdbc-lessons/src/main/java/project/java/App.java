package project.java;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;

public class App {
    public static void main(String[] args) throws SQLException {
        var tickets = findAll();
        System.out.println(tickets);
    }

    static void delete(long id) {
        var ticketDao = TicketDao.getInstance();
        boolean result = ticketDao.delete(id);
        System.out.println(result);
    }

    static Ticket read(long id) {
        var ticketDao = TicketDao.getInstance();
        return ticketDao.read(id).get();
    }

    static List<Ticket> readAll() {
        var ticketDao = TicketDao.getInstance();
        return ticketDao.readAll();
    }

    static List<Ticket> findAll() {
        var ticketDao = TicketDao.getInstance();
        return ticketDao.findAll(new TicketFilter(4, 0, "B", "Иван Розмаринов"));
    }


    static Ticket save() {
        var ticketDao = TicketDao.getInstance();
        Ticket ticket = new Ticket();
        ticket.setCost(BigDecimal.TEN);
        ticket.setSeatNo("11");
        ticket.setGetPassengerName("Иван Петров");
        ticket.setPassengerNo("23234A");
        var flight = new Flight();
        flight.setId(8L);
        flight.setStatus("asd");
        flight.setFlightNo("asd");
        ticket.setFlight(flight);
        var savedTicket = ticketDao.save(ticket);
        System.out.println(savedTicket);
        return savedTicket;
    }

    static void update(Ticket ticket) {
        var ticketDao = TicketDao.getInstance();
        ticketDao.update(ticket);
    }

    static void getImage() {
        String sql = "select image from aircraft where id=?;";
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                var image = resultSet.getBytes("image");
                //Path path = Paths.get(Objects.requireNonNull(App.class.getClassLoader().getResource("")).toURI());
                Path path = Paths.get("output.png");
                Files.write(path, image, StandardOpenOption.CREATE);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void createBlob() {
        String sql = "update aircraft set image = ? where id=1;";
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            Path path = Paths.get(App.class.getClassLoader().getResource("img.png").toURI());
            preparedStatement.setBytes(1, Files.readAllBytes(path));
            preparedStatement.executeUpdate();
        } catch (SQLException | IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    static void executeTransaction() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionManager.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.addBatch("delete from flight where id=9");
            statement.addBatch("delete from ticket where flight_id=9");
            statement.executeBatch();
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
            if (statement != null) {
                statement.close();
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
