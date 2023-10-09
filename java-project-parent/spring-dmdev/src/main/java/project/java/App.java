package project.java;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import project.java.config.JavaConfig;
import project.java.domain.Medal;
import project.java.service.CompanyService;
import project.java.service.MyThread;

import java.util.Arrays;
import java.util.Locale;


public class App {
    public static void main(String[] args) {

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("application.xml"));
        var heroBean = beanFactory.getBean("hero", Medal.class);
        var braveryBean = beanFactory.getBean("bravery", Medal.class);
        System.out.println(heroBean);
        System.out.println(braveryBean);
        System.out.println("-----------------------");
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
            String englishGreeting = context.getMessage("greeting", null, Locale.ENGLISH);
            System.out.println(englishGreeting);  // Output: Hello
            String englishGreetingRU = context.getMessage("greeting", null, Locale.forLanguageTag("ru"));
            System.out.println(englishGreetingRU);  // Output: Hello
            //System.out.println(company);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

//ClassPathXmlApplicationContext