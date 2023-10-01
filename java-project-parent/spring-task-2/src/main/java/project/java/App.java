package project.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext()) {
            context.register(Config.class);
            context.refresh();
            System.out.println(context.getBean("hello", String.class));
            System.out.println(context.getBean("version", String.class));
            context.getBean(TestService.class).test();
        }
    }
}
