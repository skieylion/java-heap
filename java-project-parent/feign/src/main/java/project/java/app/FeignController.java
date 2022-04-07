package project.java.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.java.feigns.FeignClientExample1;

@RestController
public class FeignController {

    @Autowired
    private FeignClientExample1 feignClientExample1;

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

    @GetMapping("/call")
    public OrdersRequest1C call() {
        return feignClientExample1.feign("SD04152282");
    }
}
