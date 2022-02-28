package project.java;

public class EmailNotifier extends Notifier {
    @Override
    public void run() {
        int v = ((int) (Math.random() * 100));
        System.out.println("Email: " + v);
        if (v < 80) {
            go();
        }
    }
}
