package web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("web")
@Configuration
public class WebConfig {
    @Bean
    public String httpVersion() {
        return "HTTP 1/0";
    }
}
