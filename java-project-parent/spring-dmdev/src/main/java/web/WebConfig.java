package web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public String httpVersion() {
        return "HTTP 1/0";
    }
}
