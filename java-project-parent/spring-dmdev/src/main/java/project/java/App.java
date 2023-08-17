package project.java;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.SimpleThreadScope;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
        var myThread1 = context.getBean("myThread", MyThread.class);
        var myThread2 = context.getBean("myThread", MyThread.class);

        new Thread(() -> {
            var myThread3 = context.getBean("myThread", MyThread.class);
            if (myThread1 == myThread2) {
                System.out.println("myThread1=myThread2");
            }
            if (myThread3 != myThread1) {
                System.out.println("myThread3!=myThread1");
            }
            System.out.println("end");
        }, "thread1").start();
    }
}
