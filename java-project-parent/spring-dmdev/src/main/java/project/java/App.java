package project.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.java.config.JavaConfig;
import project.java.domain.Medal;
import project.java.service.CompanyService;
import project.java.service.MyThread;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext()) {
            context.register(JavaConfig.class);
            System.out.println(Arrays.toString(context.getEnvironment().getActiveProfiles()));
            context.getEnvironment().setActiveProfiles("prod", "web");
            context.refresh();
            System.out.println(Arrays.toString(context.getEnvironment().getActiveProfiles()));
            new Thread(() -> {
                var myThread = context.getBean("myThread", MyThread.class);
                System.out.println(myThread);
            }, "t1").start();
            Thread.currentThread().join(1000);
            var myThread = context.getBean("myThread", MyThread.class);
            System.out.println(myThread);
            var bean = context.getBean("hero", Medal.class);
            var companyService = context.getBean(CompanyService.class);
            //var company = companyService.findById(1);
            companyService.todo();
            //System.out.println(company);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

//ClassPathXmlApplicationContext