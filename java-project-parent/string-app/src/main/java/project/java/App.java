package project.java;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class App {

    private static final String SERVER_IP = "192.168.0.3";
    private static int PORT = 4040;

    public static void main(String[] args) throws IOException {
        try (Socket client = new Socket(SERVER_IP, PORT)) {
            System.out.println("connect to " + client.getRemoteSocketAddress());
            try (DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                 DataInputStream dis = new DataInputStream(client.getInputStream())) {
                dos.writeUTF("Hi. I am a socket");
                System.out.println(dis.readUTF());
            }
        }
    }
}
