package project.java;

public class MessengerJson implements Messenger {
    @Override
    public void send(String jsonData) {
        System.out.println("send json data: " + jsonData);
    }
}
