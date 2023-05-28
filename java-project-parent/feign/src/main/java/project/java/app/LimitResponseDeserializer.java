package project.java.app;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class LimitResponseDeserializer extends JsonDeserializer<LimitResponseDTO> {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public LimitResponseDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        if (node.isArray()) {
            return LimitResponseDTO.builder()
                    .limits(MAPPER.readValue(node.traverse(), new TypeReference<>() {
                    }))
                    .build();
        }
        return LimitResponseDTO.builder()
                .error(MAPPER.readValue(node.traverse(), ErrorMessage.class))
                .build();
    }
}
