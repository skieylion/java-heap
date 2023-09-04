package project.java;

import project.java.dao.RequestDao;
import project.java.dao.RoomDao;
import project.java.domain.Room;
import project.java.domain.RoomClass;
import project.java.utils.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class Main {

    public static void main(String[] args) throws SQLException {
        var roomDao = RoomDao.getInstance();
        Room room = new Room();
        room.setCost(123.12);
        room.setSeats(4);
        room.setRoomClass(RoomClass.BUSINESS);
        room.setAddress("Lenina 1");
        room = roomDao.save(room);
        roomDao.read(5L).ifPresent(room1 -> {
            room1.setAddress("Lenina 5");
            roomDao.update(room1);
        });
        System.out.println(roomDao.read(5L));
        var requestDao = RequestDao.getInstance();
        var request = requestDao.read(3L).get();
        request.setRoom(room);
        request.setSeats(19);
        requestDao.update(request);

        try (var connection = ConnectionManager.getConnection();
             var stmt = connection.prepareCall("{ ? = call get_string_from_number(?) }")) {
            stmt.registerOutParameter(1, Types.VARCHAR);
            stmt.setInt(2, -3);
            System.out.println(stmt.execute());
            System.out.println("result = " + stmt.getString(1));
        }

        try (var connection = ConnectionManager.getConnection()) {
            ResultSet resultSet = connection.getMetaData().getFunctions(null, null, null);
            while (resultSet.next()) {
                String procedureName = resultSet.getString("FUNCTION_NAME");
                String procedureSchema = resultSet.getString("FUNCTION_SCHEM");
                // выводим информацию о каждой процедуре
                System.out.println("Stored Procedure");
                System.out.println("Schema: " + procedureSchema);
                System.out.println("Name: " + procedureName);
                System.out.println("------");
            }
        }
    }
}

