package project.java;

import lombok.Data;

import java.util.Date;

@Data
public class PlannedVacationTable {
    private String fullName;
    private Date startDate;
    private Date finishDate;
    private int dayCount;
    private String department;
}
