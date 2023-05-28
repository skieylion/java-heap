package project.java.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Limit {
    @JsonProperty("IDLine")
    String lineId;
    @JsonProperty("AmountOverlimit")
    Long overlimitAmount;
    @JsonProperty("AmountKR")
    Long KRAmount;
    @JsonProperty("AmountFCP")
    Long FCPAmount;
    //расходы согласованы?
    @JsonProperty("Agreed")
    Boolean agreed;
}
