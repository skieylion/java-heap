package project.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
        var companyRepository = context.getBean("companyRepository", CompanyRepository.class);
        System.out.println(companyRepository);
        System.out.println(context.getBean("pool1", ConnectionPool.class));
    }
}
