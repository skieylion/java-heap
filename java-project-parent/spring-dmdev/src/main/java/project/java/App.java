package project.java;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            var facadeProperty = context.getBean("facade", FacadeProperty.class);
            System.out.println();
            facadeProperty.getProperties()
                    .forEach((key, value) -> System.out.printf("%s = %s %n", key, value));
        }
    }
}
