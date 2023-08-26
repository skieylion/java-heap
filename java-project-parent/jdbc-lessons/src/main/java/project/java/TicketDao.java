package project.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class TicketDao {
    private static final TicketDao INSTANCE = new TicketDao();
    private static final String DELETE_SQL = "delete from ticket where id = ?";
    private static final String SAVE_SQL = "insert into ticket(passenger_no, passenger_name, flight_id, seat_no, cost)" +
            "values (?,?,?,?,?);";
    private static final String UPDATE_SQL = "update ticket set passenger_no=?, passenger_name=?, flight_id=?, seat_no=?, cost=? " +
            " where id=?";
    private static final String READ_SQL = "select id, passenger_no, passenger_name, flight_id, seat_no, cost from ticket " +
            " where id=?";
    private static final String READ_ALL_SQL = "select id, passenger_no, passenger_name, flight_id, seat_no, cost from ticket ";

    private TicketDao() {
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }

    public Ticket save(Ticket ticket) {
        try (var conntection = ConnectionManager.getConnection();
             var preparedStatement = conntection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, ticket.getPassengerNo());
            preparedStatement.setString(2, ticket.getGetPassengerName());
            preparedStatement.setLong(3, ticket.getFlightId());
            preparedStatement.setString(4, ticket.getSeatNo());
            preparedStatement.setBigDecimal(5, ticket.getCost());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                ticket.setId(resultSet.getLong("id"));
            }
            return ticket;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public Optional<Ticket> read(long id) {
        try (var conntection = ConnectionManager.getConnection();
             var preparedStatement = conntection.prepareStatement(READ_SQL)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getLong("id"));
                ticket.setCost(resultSet.getBigDecimal("cost"));
                ticket.setFlightId(resultSet.getLong("flight_id"));
                ticket.setPassengerNo(resultSet.getString("passenger_no"));
                ticket.setGetPassengerName(resultSet.getString("passenger_name"));
                ticket.setSeatNo(resultSet.getString("seat_no"));
                return Optional.of(ticket);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<Ticket> readAll() {
        try (var conntection = ConnectionManager.getConnection();
             var preparedStatement = conntection.prepareStatement(READ_ALL_SQL)) {
            List<Ticket> tickets = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getLong("id"));
                ticket.setCost(resultSet.getBigDecimal("cost"));
                ticket.setFlightId(resultSet.getLong("flight_id"));
                ticket.setPassengerNo(resultSet.getString("passenger_no"));
                ticket.setGetPassengerName(resultSet.getString("passenger_name"));
                ticket.setSeatNo(resultSet.getString("seat_no"));
                tickets.add(ticket);
            }
            return tickets;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<Ticket> findAll(TicketFilter ticketFilter) {
        List<Object> parameters = new ArrayList<>();
        List<String> whereSql = new ArrayList<>();
        Optional.ofNullable(ticketFilter.getSeatNo()).ifPresent(seatNo -> {
            whereSql.add("seat_no LIKE ?");
            parameters.add("%" + seatNo + "%");
        });
        Optional.ofNullable(ticketFilter.getPassengerName()).ifPresent(passengerName -> {
            whereSql.add("passenger_name = ?");
            parameters.add(passengerName);
        });
        parameters.add(ticketFilter.getLimit());
        parameters.add(ticketFilter.getOffset());

        String where = whereSql.stream().collect(Collectors.joining(" AND ", " WHERE ", " LIMIT ? OFFSET ? "));

        String sql = READ_ALL_SQL + where;

        try (var conntection = ConnectionManager.getConnection();
             var preparedStatement = conntection.prepareStatement(sql)) {
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getLong("id"));
                ticket.setCost(resultSet.getBigDecimal("cost"));
                ticket.setFlightId(resultSet.getLong("flight_id"));
                ticket.setPassengerNo(resultSet.getString("passenger_no"));
                ticket.setGetPassengerName(resultSet.getString("passenger_name"));
                ticket.setSeatNo(resultSet.getString("seat_no"));
                tickets.add(ticket);
            }
            return tickets;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public boolean delete(long id) {
        try (var conntection = ConnectionManager.getConnection();
             var preparedStatement = conntection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void update(Ticket ticket) {
        try (var conntection = ConnectionManager.getConnection();
             var preparedStatement = conntection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, ticket.getPassengerNo());
            preparedStatement.setString(2, ticket.getGetPassengerName());
            preparedStatement.setLong(3, ticket.getFlightId());
            preparedStatement.setString(4, ticket.getSeatNo());
            preparedStatement.setBigDecimal(5, ticket.getCost());
            preparedStatement.setLong(6, ticket.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
