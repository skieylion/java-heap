package project.java.domain;

import lombok.Data;

@Data
public class Room {
    private Long id;
    private String address;
    private Double cost;
    private Integer seats;
    private RoomClass roomClass;
}
