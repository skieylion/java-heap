package soap.example.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
//
//    @Bean
//    CommandLineRunner lookup(CountryClient quoteClient) {
//        return args -> {
//            GetCountryResponse response = quoteClient.getCountry("Spain");
//            System.err.println(response.getCountry().getCurrency());
//        };
//    }

}
