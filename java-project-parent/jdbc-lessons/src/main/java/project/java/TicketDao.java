package project.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TicketDao {
    private static final TicketDao INSTANCE = new TicketDao();
    private static final String DELETE_SQL = "delete from ticket where id = ?";
    private static final String SAVE_SQL = "insert into ticket(passenger_no, passenger_name, flight_id, seat_no, cost)" +
            "values (?,?,?,?,?);";

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

    public boolean delete(long id) {
        try (var conntection = ConnectionManager.getConnection();
             var preparedStatement = conntection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
