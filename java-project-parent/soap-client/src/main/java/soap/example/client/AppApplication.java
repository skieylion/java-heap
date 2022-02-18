package soap.example.client;

//import hello.wsdl.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import soap.example.client.config.CountryClient;
import hello.wsdl.*;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(CountryClient quoteClient) {
        return args -> {
            GetCountryResponse response = quoteClient.getCountry("Spain");
            System.err.println(response.getCountry().getCurrency());
        };
    }

}
