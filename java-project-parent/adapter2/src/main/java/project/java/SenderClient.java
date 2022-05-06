package project.java;

import java.util.ArrayList;
import java.util.List;

public class SenderClient {

    private final List<MessengerAdapter> messengerAdapterList = new ArrayList<>();

    public void addMessenger(MessengerAdapter messengerAdapter) {
        messengerAdapterList.add(messengerAdapter);
    }

    public void send(String message) {
        messengerAdapterList.forEach(messengerAdapter -> {
            messengerAdapter.send(message);
        });
    }
}
