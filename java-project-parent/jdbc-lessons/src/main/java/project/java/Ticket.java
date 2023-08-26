package project.java;

import java.math.BigDecimal;

public class Ticket {
    private Long id;
    private String passengerNo;
    private String getPassengerName;
    private Long flightId;
    private String seatNo;
    private BigDecimal cost;

    public Ticket() {
    }

    public Ticket(Long id, String passengerNo, String getPassengerName, Long flightId, String seatNo, BigDecimal cost) {
        this.id = id;
        this.passengerNo = passengerNo;
        this.getPassengerName = getPassengerName;
        this.flightId = flightId;
        this.seatNo = seatNo;
        this.cost = cost;
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

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
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
                ", flightId=" + flightId +
                ", seatNo='" + seatNo + '\'' +
                ", cost=" + cost +
                '}';
    }
}
