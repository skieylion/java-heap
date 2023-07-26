package project.java.decorator.notificator;

public class NotifierAdapter implements Notifyable {

    private final Notifier notifier;

    public NotifierAdapter(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send() {
        notifier.send();
    }
}
