package project.java.decorator.notificator;

public class FacebookDecorator extends BaseDecorator {
    public FacebookDecorator(Notifyable notificator) {
        super(notificator);
    }

    @Override
    public void send() {
        System.out.println("send to facebook");
        super.send();
    }
}
