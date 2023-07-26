package project.java.decorator.notificator;

public abstract class BaseDecorator implements Notifyable {

    private final Notifyable notificator;

    public BaseDecorator(Notifyable notificator) {
        this.notificator = notificator;
    }

    public void send() {
        notificator.send();
    }
}
