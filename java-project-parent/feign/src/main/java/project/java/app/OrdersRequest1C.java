package project.java.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
public class OrdersRequest1C {
    @JsonProperty("Result")
    private Boolean result;

    @JsonProperty("ErrorMessage")
    private List<String> errorMessage;

    @JsonProperty("ErrorCode")
    private Integer errorCode;
}
