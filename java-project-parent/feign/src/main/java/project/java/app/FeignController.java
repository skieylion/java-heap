package project.java.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import feign.Response;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.java.feigns.FeignClientDecode404;
import project.java.feigns.FeignClientExample1;
import project.java.feigns.TestFeign;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class FeignController {

    @Autowired
    private FeignClientExample1 feignClientExample1;
    @Autowired
    private FeignClientDecode404 feignClientDecode404;
    @Autowired
    private TestFeign testFeign;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/call6")
    public void call6() {

        System.out.println(objectMapper);
        LimitResponseDTO response = testFeign.getLimits();
        System.out.println("response");
//        try (InputStream is = response.body().asInputStream()) {
//            String json = new String(is.readAllBytes());
//            ObjectMapper objectMapper = new ObjectMapper();
//            if (!json.contains("ErrorCode")) {
//                TypeReference<List<Limit>> referenceLimits = new TypeReference<>() {
//                };
//                List<Limit> limits = objectMapper.readValue(json, referenceLimits);
//            } else {
//                ErrorMessage errorMessage = objectMapper.readValue(json, ErrorMessage.class);
//                String message = String.join(",", errorMessage.getErrorMessages());
//                Long code = errorMessage.getErrorCode();
//                throw new IllegalStateException(String.format("Overlimit error (%d): %s", code, message));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //System.out.println(response.body());
    }

    @GetMapping("/call5")
    public String call5() {
        Random random = new Random();
        return random.nextBoolean() ? "[ \n" +
                " { \n" +
                "\"IDLine\": \"1.1\", \n" +
                "\"AmountOverlimit\": 3000 \n" +
                " }, \n" +
                " { \n" +
                "\"IDLine\": \"2.1\", \n" +
                "\"AmountOverlimit\": 2000 \n" +
                " } \n" +
                "]" : "{\n" +
                "\"ErrorCode\": 811, \n" +
                "\"ErrorMessage\": [\"Не удалось определить документ по переданному идентификатору.\"] \n" +
                "}";
    }

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
    public void callput(@PathVariable("test") String test, @RequestBody OrdersRequest1C ordersRequest1C) {
        System.out.println(test);
        System.out.println(ordersRequest1C);
    }

    @GetMapping("/call3")
    public void call3() {
        OrdersRequest1C ordersRequest1C = new OrdersRequest1C();
        ordersRequest1C.setResult(true);
        testFeign.putmethod("123", ordersRequest1C);
    }

    @GetMapping("/call")
    //@SneakyThrows
    public ResponseEntity<Result<Boolean>> call() throws SkipException {

        //throw new SkipException();
        return ResponseEntity.status(400).body(Result.error(400, "sdf asasfg"));//.body("asd");
        //return feignClientExample1.feign("SD04152282");
    }

    @GetMapping("/call2")
    public void call2() {
        System.out.println(feignClientDecode404.getOrderRequest1COptional());
        System.out.println(feignClientDecode404.getOrderRequest1C());
    }

    @PutMapping("call")
    public void updateLunch(@RequestBody Map<String, Boolean> body) {
        System.out.println(body.get("isLunch"));
    }

}
