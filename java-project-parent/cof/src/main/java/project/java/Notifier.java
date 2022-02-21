package project.java;

public abstract class Notifier {

    private Notifier nextNotifier;

    public void setNext(Notifier nextNotifier) {
        this.nextNotifier = nextNotifier;
    }

    public void go() {
        if (nextNotifier != null) {
            nextNotifier.run();
        }
    }

    public abstract void run();
}
