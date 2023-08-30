package project.java.dao;

import project.java.domain.Room;
import project.java.domain.RoomClass;
import project.java.utils.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public final class RoomDao implements Dao<Long, Room> {
    private static final RoomDao ROOM_DAO = new RoomDao();

    private RoomDao() {

    }

    private static final String SAVE_ROOM = " INSERT INTO rooms (address, cost, seats, class) VALUES(?,?,?,?::room_class); ";
    private static final String READ_ROOM = " select id, address, cost, seats, class from rooms where id=? ";
    private static final String DELETE_ROOM = " delete from rooms where id=? ";
    private static final String UPDATE_ROOM = " update rooms set address=?, cost=?, seats=?, class=?::room_class  where id=? ";

    @Override
    public Room save(Room room) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(SAVE_ROOM, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, room.getAddress());
            preparedStatement.setDouble(2, room.getCost());
            preparedStatement.setInt(3, room.getSeats());
            System.out.println(room.getRoomClass().getType());
            preparedStatement.setString(4, room.getRoomClass().getType());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                room.setId(resultSet.getLong("id"));
                return room;
            }
            throw new DaoException("Can't save room");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Room> read(Long id) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(READ_ROOM)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getLong("id"));
                room.setAddress(resultSet.getString("address"));
                room.setSeats(resultSet.getInt("seats"));
                room.setCost(resultSet.getDouble("cost"));
                room.setRoomClass(RoomClass.BUSINESS.getType().equals(resultSet.getString("class"))
                        ? RoomClass.BUSINESS : RoomClass.ECONOMY);
                return Optional.of(room);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(DELETE_ROOM)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Room entity) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(UPDATE_ROOM)) {
            preparedStatement.setString(1, entity.getAddress());
            preparedStatement.setDouble(2, entity.getCost());
            preparedStatement.setInt(3, entity.getSeats());
            preparedStatement.setString(4, entity.getRoomClass().getType());
            preparedStatement.setLong(5, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static RoomDao getInstance() {
        return ROOM_DAO;
    }
}
