package project.java;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TicketFilter {
    private long limit;
    private long offset;
    private String seatNo;
    private String passengerName;
}
