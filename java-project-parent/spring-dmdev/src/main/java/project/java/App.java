package project.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            var myThread = context.getBean("myThread", MyThread.class);
            //var facadeProperty = context.getBean("facade", FacadeProperty.class);
//            System.out.println();
//            facadeProperty.getProperties()
//                    .forEach((key, value) -> System.out.printf("%s = %s %n", key, value));
        }
    }
}
