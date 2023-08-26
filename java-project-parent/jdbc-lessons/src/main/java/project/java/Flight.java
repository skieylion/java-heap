package project.java;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flight {
    private Long id;
    private String flightNo;
    private String status;

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNo='" + flightNo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
