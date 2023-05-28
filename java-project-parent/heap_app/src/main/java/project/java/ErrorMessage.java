package project.java;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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
