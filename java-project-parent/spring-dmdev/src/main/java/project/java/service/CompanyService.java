package project.java.service;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import project.java.domain.Company;
import project.java.listener.AccessType;
import project.java.listener.EntityEvent;

import java.util.Optional;

@Service
public abstract class CompanyService {
    private final ApplicationEventPublisher publisher;
    private final CompanyService self;

    //+++

    public CompanyService(ApplicationEventPublisher publisher, @Lazy CompanyService self) {
        this.publisher = publisher;
        this.self = self;
    }

    public Optional<Company> findById(long id) {
        System.out.println("CompanyService::findById");
        Company company = new Company(1);
        publisher.publishEvent(new EntityEvent(company, AccessType.READ));
        return Optional.of(company);
    }

    public void todo() {
        System.out.println("to do start");
        System.out.println(self.findById(123L));
        System.out.println(getSelf().findById(123L));
        System.out.println("to do end");
    }

    @Lookup
    public abstract CompanyService getSelf();
}
