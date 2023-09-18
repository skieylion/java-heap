package project.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.java.config.JavaConfig;
import project.java.domain.Medal;
import project.java.repository.CrudRepository;
import project.java.service.MyThread;


public class App {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(JavaConfig.class)) {
            new Thread(() -> {
                var myThread = context.getBean("myThread", MyThread.class);
                System.out.println(myThread);
            }, "t1").start();
            Thread.currentThread().join(1000);
            var myThread = context.getBean("myThread", MyThread.class);
            System.out.println(myThread);
            var bean = context.getBean("hero", Medal.class);
            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            var company = companyRepository.findById(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

//ClassPathXmlApplicationContext