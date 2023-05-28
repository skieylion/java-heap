package project.java;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Console;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import project.java.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException, InterruptedException {
        Runnable runnable=new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Console.main();
            }
        };
        runnable.run();


        EntityManagerFactory emf= Persistence.createEntityManagerFactory("Persistence");
        EntityManager em=emf.createEntityManager();

        em.getTransaction().begin();
        Person person = new Person();
        person.setFirstName("Василий");
        person.setLastName("Иванов");
        em.persist(person);
        System.out.println(person.getId());
        em.getTransaction().commit();
        em.close();

        EntityManager em1=emf.createEntityManager();
        em1.getTransaction().begin();
        List<Person> personList=em1.createQuery("select p from Person p").getResultList();
        personList.get(0).setFirstName("Иннокентий");
        em1.getTransaction().commit();
        em1.close();
    }

    private static SessionFactory createSessionFactory() {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder()
                .build();
        return metadata.getSessionFactoryBuilder().build();
    }
}
