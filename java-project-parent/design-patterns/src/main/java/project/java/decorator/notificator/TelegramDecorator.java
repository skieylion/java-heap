package project.java.decorator.notificator;

public class TelegramDecorator extends BaseDecorator {
    public TelegramDecorator(Notifyable notificator) {
        super(notificator);
    }

    @Override
    public void send() {
        System.out.println("send to telegram");
        super.send();
    }
}
