package project.java;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(" start");

        MyThread myThread1 = new MyThread("thread1");
        MyThread myThread2 = new MyThread("thread2");

        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);

        //thread1.setPriority(Thread.NORM_PRIORITY-2);
        //thread2.setPriority(Thread.NORM_PRIORITY+2);

        thread1.start();
        thread2.start();


        thread1.join(); //ждем первый поток
        System.out.println("#1 joined "+myThread1.count);
        thread2.join(); //ждем второй поток
        System.out.println("#2 joined "+myThread2.count);

//        for (int i=0;i<10;i++) {
//            Thread.sleep(400);
//            System.out.println("general thread : "+i);
//        }



        System.out.println(" end");
    }
}
