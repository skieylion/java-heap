package project.java.dao;

import project.java.domain.Request;
import project.java.domain.Room;
import project.java.domain.RoomClass;
import project.java.utils.ConnectionManager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public final class RequestDao implements Dao<Long, Request> {
    private static final RequestDao REQUEST_DAO = new RequestDao();

    private RequestDao() {

    }

    private static final String SAVE_REQUEST = " INSERT INTO requests (date_from, date_to, seats,room_id) VALUES(?,?,?,?); ";
    private static final String READ_REQUEST = " select id, date_from, date_to, seats, room_id from requests where id=? ";
    private static final String DELETE_REQUEST = " delete from requests where id=? ";
    private static final String UPDATE_REQUEST = " update requests set date_to=?, date_from=?, seats=?, room_id=?  where id=? ";

    @Override
    public Request save(Request request) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(SAVE_REQUEST, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDate(1, new Date(request.getDateFrom().getTime()));
            preparedStatement.setDate(2, new Date(request.getDateTo().getTime()));
            preparedStatement.setInt(3, request.getSeats());
            preparedStatement.setLong(4, request.getRoom().getId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                request.setId(resultSet.getLong("id"));
                return request;
            }
            throw new DaoException("Can't save request");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Request> read(Long id) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(READ_REQUEST)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Request request = new Request();
                request.setId(resultSet.getLong("id"));
                request.setDateFrom(resultSet.getDate("date_from"));
                request.setDateTo(resultSet.getDate("date_to"));
                request.setSeats(resultSet.getInt("seats"));
                long room_id = resultSet.getLong("room_id");
                Room room = RoomDao.getInstance().read(room_id).orElse(null);
                request.setRoom(room);
                return Optional.of(request);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(DELETE_REQUEST)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Request request) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(UPDATE_REQUEST)) {
            preparedStatement.setDate(1, new Date(request.getDateFrom().getTime()));
            preparedStatement.setDate(2, new Date(request.getDateTo().getTime()));
            preparedStatement.setInt(3, request.getSeats());
            preparedStatement.setLong(4, request.getRoom().getId());
            preparedStatement.setLong(5, request.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static RequestDao getInstance() {
        return REQUEST_DAO;
    }
}
