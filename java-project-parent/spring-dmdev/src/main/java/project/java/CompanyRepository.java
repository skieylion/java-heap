package project.java;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("companyRepository")
@Transaction
public class CompanyRepository implements CrudRepository<Integer, Company> {
    @InjectBean
    private ConnectionPool connectionPool;

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
