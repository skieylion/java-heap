package project3.java3;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Messenger messenger=new AdapterMessenger();
        //Messenger messenger=new AdapterMessenger();
        String jsonData="{'a':1}";
        messenger.send(jsonData);
        //System.out.println( "Hello World!" );
    }
}
