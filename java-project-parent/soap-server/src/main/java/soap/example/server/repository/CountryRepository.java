package soap.example.server.repository;

import org.springframework.stereotype.Component;
import soap.example.server.xsd.Country;
import soap.example.server.xsd.Currency;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        // initialize countries map
    }

    public Country findCountry(String name) {
        Country country=new Country();
        country.setCapital("Moscow");
        country.setName("Russia");
        country.setCurrency(Currency.EUR);
        country.setPopulation(146_000_000);
        return country;
    }
}