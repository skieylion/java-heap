package project.java.service;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import project.java.domain.Company;
import project.java.listener.AccessType;
import project.java.listener.EntityEvent;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyService {
    private final ApplicationEventPublisher publisher;

    public Optional<Company> findById(long id) {
        Company company = new Company(1);
        publisher.publishEvent(new EntityEvent(company, AccessType.READ));
        return Optional.of(company);
    }
}
