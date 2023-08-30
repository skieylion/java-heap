package project.java;

import project.java.dao.RequestDao;
import project.java.dao.RoomDao;
import project.java.domain.Room;
import project.java.domain.RoomClass;

import java.sql.SQLException;
import java.util.Collections;

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
        Collections s;
    }
}

