package project.java;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class LimitResponseDeserializer extends JsonDeserializer<LimitResponseDTO> {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public LimitResponseDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        System.out.println("LimitResponseDeserializer json = " + node.toPrettyString());
        if (node.isArray()) {
            return LimitResponseDTO.builder()
                    .limits(MAPPER.readValue(node.traverse(), new TypeReference<>() {
                    }))
                    .build();
        }
        return LimitResponseDTO.builder()
                .limits(new ArrayList<>())
                .error(MAPPER.readValue(node.traverse(), ErrorMessage.class))
                .build();
    }
}
