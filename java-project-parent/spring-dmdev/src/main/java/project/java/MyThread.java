package project.java;

import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyThread {

    public String getName() {
        return "NAME";
    }

    @PostConstruct
    public void init() {
        System.out.println("init MyThread");
        CommonAnnotationBeanPostProcessor sa;
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy MyThread");
    }
}
