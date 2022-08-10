package project.java;



public class App {

    static void test(AppI obj) {
        System.out.println("AppI");
    }

    static void test(AppTest obj) {
        System.out.println("AppTest");
    }

    static void test(App obj) {
        System.out.println("App");
    }

    public static void main(String[] args) {
        App obj=new AppTest2();
        test(obj);
    }
}

interface AppI {

}

class AppTest extends App implements AppI {

}

class AppTest2 extends App implements AppI {

}