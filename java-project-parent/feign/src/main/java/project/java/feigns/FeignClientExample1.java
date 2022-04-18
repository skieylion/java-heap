package project.java.feigns;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.java.app.OrdersRequest1C;
import project.java.config.FeignClientConfig;

@FeignClient(
        //value = "client1",
        url = "localhost:8089",
        path = "ddd",
        configuration = FeignClientConfig.class,
        name = "albums-ws",
        fallback = MyFallbackTest.class
)
public interface FeignClientExample1 {
    @GetMapping("/mock-data-service/orderstatus")
    OrdersRequest1C feign(@RequestParam("sd_num") String sdNum);
}

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class MyFallbackTest implements FeignClientExample1 {

    @Override
    public OrdersRequest1C feign(String sdNum) {
        System.out.println("test hystrix");
        return new OrdersRequest1C();
    }
}
