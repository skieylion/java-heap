package project.java;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            System.out.println();
            Stream.of("Alex", "Simon").forEach(name -> {
                System.out.println("name: " + name);
                var person = context.getBean(name, Person.class);
                System.out.println("MEDALS:");
                person.getMedals().forEach(medal -> System.out.println(medal.getName()));
                System.out.println("BOOK: " + person.getBooks().get(0).getTitle());
                System.out.println("ADDRESS: " + person.getAddress().getFullAddress());
                System.out.println();
            });

        }
    }
}
