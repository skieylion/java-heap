package project.java;

import lombok.extern.java.Log;

@Log
public class SmsMessengerAdapter implements MessengerAdapter {
    private final MessengerAdaptee messengerAdaptee;
    public SmsMessengerAdapter(MessengerAdaptee messengerAdaptee) {
        this.messengerAdaptee = messengerAdaptee;
    }
    @Override
    public void send(String message) {
        log.info("sms adapter:");
        messengerAdaptee.sendSmsMessage(message);
    }
}
