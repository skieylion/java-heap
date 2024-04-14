package project.java;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;

public class App {

    private static volatile int x = 0;

    static void threads() throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong(0);

        var thread1 = new Thread(() -> {
            while (true) {
                if (x == 50) {
                    System.out.println("x");
                    break;
                }
            }
        });
        var thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                x++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(x);
        });
        thread1.start();
        thread2.start();
        thread2.join();
        thread1.join();
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new BlockingQueue(4);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                int value = new Random().nextInt(1000) + 1;
                blockingQueue.put(value);
                System.out.println("add:" + value + " - " + blockingQueue.getSize());
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("delete:" + blockingQueue.take() + " - " + blockingQueue.getSize());
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        thread1.start();
        thread2.start();


        //Test.main(null);


//        Thread myThread = new Thread(() -> {
//            while (!Thread.currentThread().isInterrupted()) {
//                System.out.println("Thread is running");
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    System.out.println("Thread is interrupted");
//                    Thread.currentThread().interrupt();
//                    System.out.println("1");
//                }
//            }
//            System.out.println("2");
//        });
//        myThread.start();
//        System.out.println("myThread is started");
//        Thread.currentThread().sleep(2000);
//        System.out.println("Finish myThread");
//        myThread.interrupt();
//        myThread.join();
//        System.out.println("myThread is finished");
    }
}

class Test {
    private final static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable1(), "t1");
        Thread t2 = new Thread(new MyRunnable2(), "t2");
        t1.start();
        t2.start();
    }

    private static class MyRunnable1 implements Runnable {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("R1 start");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("R1 end");
            }
        }
    }

    private static class MyRunnable2 implements Runnable {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("R2 start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                object.notify();
                System.out.println("R2 end");
            }
        }
    }
}