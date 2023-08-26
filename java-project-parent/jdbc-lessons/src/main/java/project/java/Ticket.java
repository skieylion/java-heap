package project.java;

import java.math.BigDecimal;

public class Ticket {
    private Long id;
    private String passengerNo;
    private String getPassengerName;
    private Flight flight;
    private String seatNo;
    private BigDecimal cost;

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerNo() {
        return passengerNo;
    }

    public void setPassengerNo(String passengerNo) {
        this.passengerNo = passengerNo;
    }

    public String getGetPassengerName() {
        return getPassengerName;
    }

    public void setGetPassengerName(String getPassengerName) {
        this.getPassengerName = getPassengerName;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", passengerNo='" + passengerNo + '\'' +
                ", getPassengerName='" + getPassengerName + '\'' +
                ", flight=" + flight +
                ", seatNo='" + seatNo + '\'' +
                ", cost=" + cost +
                '}';
    }
}
