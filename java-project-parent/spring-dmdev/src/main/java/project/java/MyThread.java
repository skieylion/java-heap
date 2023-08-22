package project.java;

public class MyThread {

    public String getName() {
        return "NAME";
    }

    private void init() {
        System.out.println("init MyThread");
    }

    private void destroy() {
        System.out.println("destroy MyThread");
    }
}
