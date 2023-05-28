package project.java.feigns;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import project.java.app.LimitResponseDTO;
import project.java.app.LimitResponseDeserializer;
import project.java.app.OrdersRequest1C;
import project.java.config.FeignClientConfig;

@FeignClient(url = "localhost:8080", name = "test", configuration = FeignClientConfig.class)
public interface TestFeign {
    @PutMapping("/putmethod/{test}")
    void putmethod(@PathVariable("test") String test, @RequestBody OrdersRequest1C ordersRequest1C);

    @GetMapping(value = "/call5", produces = "application/json")
    LimitResponseDTO getLimits();
}
