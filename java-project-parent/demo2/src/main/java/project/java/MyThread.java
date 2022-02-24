package project.java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyThread implements Runnable {

    private static boolean stop = false;
    private final String name;
    public static int count = 0;
    public static final List<Integer> arr = new ArrayList<>();

    static {
        arr.add(1);
    }


    MyThread(String name) {
        this.name = name;
    }

    private static synchronized void sum() throws InterruptedException {
        arr.add(arr.get(arr.size() - 1) + 1);
    }

    private void sum2() {
        synchronized (arr) {
            arr.add(arr.get(arr.size() - 1) + 1);
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                sum2();
                Thread.sleep(100);
            }
            System.out.println("arr =>");
            System.out.println(arr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println(name + " start");
//        do {
//            count++;
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        } while(count < 10_000&& !stop);
//        stop=true;
//
//        System.out.println(name + " end");
    }
}
