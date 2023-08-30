package project.java.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Request {
    private Long id;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private Integer seats;
}
