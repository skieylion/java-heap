package project.java.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import project.java.app.OrdersRequest1C;
import project.java.config.FeignClientConfig;

import java.util.Optional;

@FeignClient(url = "localhost:8080", name = "feignRepeater", configuration = FeignClientConfig.class)
public interface FeignRepeaterClient {
    @GetMapping("/retry-get")
    String getRetry();
}
