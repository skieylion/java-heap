package project.java;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Singleton1 s1 = Singleton1.getInstance();
        Singleton2 s2 = Singleton2.getInstance();


    }
}
class Singleton1 {
    private final static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}
class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

