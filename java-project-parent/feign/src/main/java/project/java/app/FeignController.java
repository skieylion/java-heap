package project.java.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.java.feigns.FeignClientDecode404;
import project.java.feigns.FeignClientExample1;
import project.java.feigns.TestFeign;

@RestController
public class FeignController {

    @Autowired
    private FeignClientExample1 feignClientExample1;
    @Autowired
    private FeignClientDecode404 feignClientDecode404;
    @Autowired
    private TestFeign testFeign;

    @GetMapping("/ddd/feign")
    public OrdersRequest1C feign(@RequestParam("sd_num") String sdNum) throws Exception {
        System.out.println(sdNum);
        ObjectMapper objectMapper = new ObjectMapper();
        OrdersRequest1C ordersRequest1C = objectMapper.readValue("{\n" +
                "\t\"ErrorMessage\": [\n" +
                "\t\t\"По переданному номеру обращения уже существует заказ в 1С АХД\"\n" +
                "\t],\n" +
                "\t\"ErrorCode\": 802\n" +
                "}", OrdersRequest1C.class);
        throw new RuntimeException("asd");
    }

    @PutMapping("/putmethod/{test}")
    public void callput(@PathVariable("test") String test,@RequestBody OrdersRequest1C ordersRequest1C) {
        System.out.println(test);
        System.out.println(ordersRequest1C);
    }

    @GetMapping("/call3")
    public void call3() {
        OrdersRequest1C ordersRequest1C=new OrdersRequest1C();
        ordersRequest1C.setResult(true);
        testFeign.putmethod("123",ordersRequest1C);
    }

    @GetMapping("/call")
    //@SneakyThrows
    public OrdersRequest1C call() {
        return feignClientExample1.feign("SD04152282");
    }

    @GetMapping("/call2")
    public void call2() {
        System.out.println(feignClientDecode404.getOrderRequest1COptional());
        System.out.println(feignClientDecode404.getOrderRequest1C());
    }


}
