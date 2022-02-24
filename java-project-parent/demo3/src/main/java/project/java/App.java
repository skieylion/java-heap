package project.java;

import java.util.concurrent.Future;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final Object object = new Object();
        Thread t1 = new Thread() {
            public void run()
            {
                synchronized (object) {
                    System.out.println("T1 start!");
                    try {
                        object.wait();
                        System.out.println("!!!");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T1 end!");
                }
            }
        };
        Thread t2 = new Thread() {
            public void run()
            {
                synchronized (object) {
                    System.out.println("T2 start!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    object.notify();
                    System.out.println("T2 end!");
                }
            }
        };

        t1.start();
        t2.start();


    }
}
