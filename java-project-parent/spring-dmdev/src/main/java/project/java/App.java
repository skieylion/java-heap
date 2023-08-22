package project.java;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class App {
    public static void main(String[] args) {
        PropertySourcesPlaceholderConfigurer s;
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            var pool = context.getBean("pool1", ConnectionPool.class);
            System.out.println(pool);
        }
    }
}
