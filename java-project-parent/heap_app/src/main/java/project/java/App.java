package project.java;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}

public class App {

    @MyAnno(str = "asd", val = 1)
    public void myMeth() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        App app = new App();
        Class<?> c = app.getClass();
        Method m = c.getMethod("myMeth");
        MyAnno myAnno = m.getAnnotation(MyAnno.class);
        System.out.println("myAnno str=" + myAnno.str() + "; val=" + myAnno.val());
    }
}

