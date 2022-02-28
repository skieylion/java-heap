package project.java;

public class CallNotifier extends Notifier {
    @Override
    public void run() {
        int v = ((int) (Math.random() * 100));
        System.out.println("Call: " + v);
        if (v < 5) {
            go();
        }
    }
}
