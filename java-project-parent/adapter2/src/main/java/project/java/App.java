package project.java;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        SenderClient senderClient=new SenderClient();
        MessengerAdaptee messengerAdaptee=new MessengerAdaptee();

        senderClient.addMessenger(new SmsMessengerAdapter(messengerAdaptee));
        senderClient.addMessenger(new EmailMessengerAdapter(messengerAdaptee));
        senderClient.addMessenger(new MessengerAdapter() {
            @Override
            public void send(String message) {
                messengerAdaptee.sendSoundMessage(message);
            }
        });


        senderClient.send("Hello, I am glad to see you!!!");

        System.out.println( "Hello World!" );
    }
}
