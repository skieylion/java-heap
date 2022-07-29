package project.java;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class App {

    @MyAnno(str = "asd", val = 1)
    public static void myMeth() {

    }

    public static void main(String[] args) {

    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();

    int val();
}