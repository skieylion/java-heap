package project.java;

import lombok.extern.java.Log;

@Log
public class EmailMessengerAdapter implements MessengerAdapter {

    private final MessengerAdaptee messengerAdaptee;

    public EmailMessengerAdapter(MessengerAdaptee messengerAdaptee) {
        this.messengerAdaptee = messengerAdaptee;
    }

    @Override
    public void send(String message) {
        log.info("email adapter:");
        messengerAdaptee.sendEmailMessage(message);
    }
}
