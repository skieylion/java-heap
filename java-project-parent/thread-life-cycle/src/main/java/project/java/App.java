package project.java;


public class App {

    static final Object object = new Object();

    static Thread t1 = new Thread(() -> {
        try {
            synchronized (object) {
                for (int i = 0; i < 2; i++) {
                    System.out.println("the object is blocked for 500 ms (" + i + ")");
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("The thread is interrupted", e);
        }
    }, "t1");

    static Thread t2 = new Thread(() -> {
        synchronized (object) {
            System.out.println("t2 is waiting");
        }
    }, "t2");

    static Thread t3 = new Thread(() -> {
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("Couldn't join t2", e);
        }
    }, "t3");

    private static void printState(Thread t) {
        System.out.printf("state = %s (%s)%n", t.getState(), t.getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Object obj=new Object();
        obj.notify();
        printState(t1);
        t1.start();
        printState(t1);
        Thread.currentThread().join(100);
        printState(t1);
        t2.start();
        Thread.currentThread().join(100);
        printState(t2);
        t3.start();
        Thread.currentThread().join(100);
        printState(t3);
        t1.join();
        printState(t1);
    }
}
