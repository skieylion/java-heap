package project.java;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ServerRunner {
    public static void run(int port) throws UnknownHostException, SocketException {
        final Map<String, byte[]> files = new HashMap<>();
        InetAddress address = InetAddress.getByName("0.0.0.0");
        try (ServerSocket serverSocket = new ServerSocket(port, 50, address)) {
            System.out.println("server is running on port " + port);
            System.out.println("IP: " + address.getHostAddress());
            try (Socket socket = serverSocket.accept();
                 BufferedInputStream input = new BufferedInputStream(socket.getInputStream());
                 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                System.out.println("socket is accepted for address " + socket.getInetAddress().getHostAddress());
                byteArrayOutputStream.write(input.readAllBytes());
                String uuid = UUID.randomUUID().toString();
                files.put(uuid, byteArrayOutputStream.toByteArray());
                bufferedWriter.write(uuid);
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
            }
            Thread.sleep(1000);
            System.out.println("socket is closed");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println("server is closed");
    }
}
