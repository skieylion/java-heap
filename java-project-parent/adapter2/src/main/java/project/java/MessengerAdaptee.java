package project.java;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Getter
@Setter
public class MessengerAdaptee {
    public void sendSmsMessage(String message) {
        log.info("sms message: " + message);
    }

    public void sendEmailMessage(String message) {
        log.info("email message: " + message);
    }

    public void sendSoundMessage(String message) {
        log.info("sound message: " + message);
    }
}
