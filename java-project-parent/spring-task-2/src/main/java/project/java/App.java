package project.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext()) {
            context.register(Config.class);
            context.refresh();
            System.out.println(context.getBean("hello", String.class));
            context.getBean("testService", TestService.class).test();
            System.out.println(">>>------------bean1");
            var selfBean1 = context.getBean(SelfInjectionBean1.class);
            System.out.println(selfBean1);
            selfBean1.log();
            selfBean1.log();
            System.out.println("<<<------------bean1");
            System.out.println(">>>------------bean2");
            var selfBean2 = context.getBean(SelfInjectionBean2.class);
            System.out.println(selfBean2);
            selfBean2.log();
            selfBean2.log();
            System.out.println("<<<------------bean2");
            System.out.println(">>>------------bean3");
            var selfBean3 = context.getBean(SelfInjectionBean3.class);
            System.out.println(selfBean3);
            selfBean3.todo();
            System.out.println("<<<------------bean3");
        }
    }
}
