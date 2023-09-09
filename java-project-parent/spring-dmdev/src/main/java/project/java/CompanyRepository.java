package project.java;

import java.util.Optional;

@Transaction
public class CompanyRepository implements CrudRepository<Integer, Company> {
    @InjectBean
    private ConnectionPool connectionPool;

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("find by id = " + id);
        return Optional.of(new Company(id));
    }

    @Override
    public void deleteById(Integer id) {
        System.out.println("delete by id = " + id);
    }
}
