package project.java.feigns;

import org.springframework.stereotype.Component;
import project.java.app.OrdersRequest1C;

//@Component
public class MyFallback implements FeignClientExample1 {

    @Override
    public OrdersRequest1C feign(String sdNum) {
        System.out.println("test hystrix");
        return new OrdersRequest1C();
    }
}
