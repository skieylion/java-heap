package project.java.app;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@JsonDeserialize(using = LimitResponseDeserializer.class)
@Getter
@Builder
public class LimitResponseDTO {
    private List<Limit> limits;
    private ErrorMessage error;
}
