package project.java.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    @JsonProperty("ErrorCode")
    private Long errorCode;
    @JsonProperty("ErrorMessage")
    private java.util.List<String> errorMessages;

    @Override
    public String toString() {
        String errors = errorMessages != null ? String.join(",", errorMessages) : "null";
        return "ErrorMessage{" +
                "errorCode=" + errorCode +
                ", errorMessages=" + errors +
                '}';
    }
}
