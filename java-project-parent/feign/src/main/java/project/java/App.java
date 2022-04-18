package project.java;


import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableFeignClients
//@EnableCircuitBreaker
//@EnableDiscoveryClient
//@EnableHystrix
public class App 
{
    public static void main( String[] args )
    {
        Test test=new Test();
        System.out.println(test.x);
        //System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
        //applicationContext.getBean(Runner.class).run();
    }

    //@AllArgsConstructor
    private static final class Test {
        private final String x;
        public Test(){
            this.x="static constructor";
        }
    }

}
