package project.java;


import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import project.java.app.Runner;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
@EnableFeignClients
//@EnableCircuitBreaker
//@EnableDiscoveryClient
//@EnableHystrix
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException, URISyntaxException {

//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI("https://audio.oxforddictionaries.com/en/mp3/work__gb_1.mp3"))
//                .GET()
//                .build();
//        HttpResponse<String> response = HttpClient.newBuilder()
//                .build()
//                .send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
        //https://audio.oxforddictionaries.com/en/mp3/work__gb_1.mp3
        //Test test=new Test();
        //System.out.println(test.x);
        //System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args).getBean(Runner.class).run();
    }

    //@AllArgsConstructor
    private static final class Test {
        private final String x;
        public Test(){
            this.x="static constructor";
        }
    }

}
