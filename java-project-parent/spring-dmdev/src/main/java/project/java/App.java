package project.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            var myThread1 = context.getBean("myThread", MyThread.class);
            var myThread2 = context.getBean("myThread", MyThread.class);
            if (myThread1 != myThread2) {
                System.out.println("myThread1!=myThread2");
            }
        }
    }
}
