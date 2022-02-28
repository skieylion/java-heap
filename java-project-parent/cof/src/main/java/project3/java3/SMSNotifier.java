package project3.java3;

public class SMSNotifier extends Notifier {

    @Override
    public void run() {
        int v = ((int) (Math.random() * 100));
        System.out.println("SMS: " + v);
        if (v < 20) {
            go();
        }
    }
}
