package project.java.feigns;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.java.app.OrdersRequest1C;
import project.java.config.FeignClientConfig;

@FeignClient(
        //value = "client1",
        url = "localhost:8080",
        path = "ddd",
        configuration = FeignClientConfig.class,
        name = "albums-ws",
        fallback = MyFallbackTest.class
)
public interface FeignClientExample1 {
    @GetMapping("/feign")
    OrdersRequest1C feign(@RequestParam("sd_num") String sdNum);
}

@Component
class MyFallbackTest implements FeignClientExample1 {

    @Override
    public OrdersRequest1C feign(String sdNum) {
        System.out.println("test hystrix");
        return new OrdersRequest1C();
    }
}
