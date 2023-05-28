package project.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;

public class App {

    private static int COUNT_MAX = 5;

    private static int getCount() {
        System.out.println("The attempt №" + COUNT_MAX);
        return --COUNT_MAX;
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(4040)) {
            System.out.println("The server is created");
            server.setSoTimeout(10000);
            System.out.println("The address = " + server.getInetAddress().getHostAddress());
            while (getCount() > 0) {
                System.out.println("The server is waiting clients");
                try (Socket client = server.accept()) {
                    System.out.println("The address client is " + client.getLocalSocketAddress());
                    try (DataInputStream dis = new DataInputStream(client.getInputStream());
                         DataOutputStream dos = new DataOutputStream(client.getOutputStream())) {
                        System.out.println(dis.readUTF());
                        dos.writeUTF("Hi. I am a server");
                    }
                } catch (SocketTimeoutException e) {
                    System.out.println("The time is ended");
                }
            }
            System.out.println("The server is closed");
        }
    }
}