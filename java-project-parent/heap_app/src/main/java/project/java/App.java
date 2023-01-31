package project.java;

public class App {

    private static Integer count = 0;
    private static final Object object = new Object();

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException("Couldn't sleep thread", e);
        }
    }

    static Runnable runnable = () -> {
        for (int i = 0; i < 10; i++) {
            synchronized (object) {
                count++;
                System.out.println(Thread.currentThread().getName() + " = " + count);
            }
            sleep();
        }
        //Добавили комментарий для test2
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        t1.start();
        t2.start();
        //Добавили комментарий
        //Добавим комментарий для test1
        //add comments
        //коммент 1
        //коммент 2
    }
}
