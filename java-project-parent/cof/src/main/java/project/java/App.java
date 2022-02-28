package project.java;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Notifier n1=new EmailNotifier();
        Notifier n2=new SMSNotifier();
        Notifier n3=new CallNotifier();

        n1.setNext(n2);
        n2.setNext(n3);

        n1.run();
        //System.out.println( "Hello World!" );
    }
}
