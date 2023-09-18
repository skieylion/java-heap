package project.java.repository;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import project.java.utils.ConnectionPool;
import project.java.service.MyThread;
import project.java.annotation.InjectBean;
import project.java.annotation.Transaction;
import project.java.domain.Company;

import java.util.Optional;

@Repository("companyRepository")
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Transaction
public class CompanyRepository implements CrudRepository<Integer, Company> {
    @InjectBean
    private ConnectionPool connectionPool;

    @Autowired
    private MyThread myThread;

    @Getter
    @Value("#{systemProperties['user.country']}")
    private String value;

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("find by id = " + id);
        System.out.println("value = " + value);
        return Optional.of(new Company(id));
    }

    @Override
    public void deleteById(Integer id) {
        System.out.println("delete by id = " + id);
    }
}
