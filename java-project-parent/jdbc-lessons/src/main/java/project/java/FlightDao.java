package project.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight> {
    private static final FlightDao INSTANCE = new FlightDao();
    private static final String DELETE_SQL = "delete from flight where id = ?";
    private static final String SAVE_SQL = " insert into flight(flight_no, status) " +
            " values (?,?); ";
    private static final String UPDATE_SQL = "update flight set flight_no=?, status=? " +
            " where id=? ";
    private static final String READ_SQL = "select id, flight_no, status from flight " +
            " where id=? ";
    private static final String READ_ALL_SQL = "select id, flight_no, status " +
            " from flight ";

    @Override
    public Flight save(Flight entity) {
        try (var conntection = ConnectionManager.getConnection();
             var preparedStatement = conntection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getFlightNo());
            preparedStatement.setString(2, entity.getStatus());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                entity.setId(resultSet.getLong("id"));
            }
            return entity;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Flight> read(Long entityId) {
        try (var conntection = ConnectionManager.getConnection();
             var preparedStatement = conntection.prepareStatement(READ_SQL)) {
            preparedStatement.setLong(1, entityId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getLong("id"));
                flight.setFlightNo(resultSet.getString("flight_no"));
                flight.setStatus(resultSet.getString("status"));
                return Optional.of(flight);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(Long entityId) {
        try (var conntection = ConnectionManager.getConnection();
             var preparedStatement = conntection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setLong(1, entityId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Flight entity) {
        try (var conntection = ConnectionManager.getConnection();
             var preparedStatement = conntection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, entity.getFlightNo());
            preparedStatement.setString(2, entity.getStatus());
            preparedStatement.setLong(3, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static FlightDao getInstance() {
        return INSTANCE;
    }
}
