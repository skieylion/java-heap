package project.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            var myThread = context.getBean("myThread", MyThread.class);
            var bean = context.getBean("hero", Medal.class);
            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            var company = companyRepository.findById(1);
        }
    }
}
