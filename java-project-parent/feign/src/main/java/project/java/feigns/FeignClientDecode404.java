package project.java.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.java.app.OrdersRequest1C;

import java.util.Optional;

@FeignClient(url = "localhost:8080",name = "any",decode404 = true)
public interface FeignClientDecode404 {

    @GetMapping("/method1")
    Optional<OrdersRequest1C> getOrderRequest1COptional();

    @GetMapping("/method2")
    OrdersRequest1C getOrderRequest1C();
}
