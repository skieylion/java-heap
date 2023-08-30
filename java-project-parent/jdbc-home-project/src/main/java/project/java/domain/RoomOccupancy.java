package project.java.domain;

import lombok.Data;

import java.util.Date;

@Data
public class RoomOccupancy {
    private Long id;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
}
