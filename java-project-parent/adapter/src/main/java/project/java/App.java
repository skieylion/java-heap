package project.java;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Reader;

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
