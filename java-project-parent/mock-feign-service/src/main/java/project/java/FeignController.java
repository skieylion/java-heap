package project.java;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketException;

@RestController
public class FeignController {
    @GetMapping("retry-get")
    public ResponseEntity<String> retryTestControllerGet() throws InterruptedException, SocketException {
        //Thread.sleep(2_000);
        return ResponseEntity.status(503).build();
    }
}
