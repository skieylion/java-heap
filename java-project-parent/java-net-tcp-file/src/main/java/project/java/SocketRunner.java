package project.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.nio.file.Path;

public class SocketRunner {
    public static void run(String host, int port, String filePath) throws IOException {
        try {
            InetAddress address = InetAddress.getByName(host);
            System.out.println("try to connect on address " + address.getHostName() + " with port " + port);
            int x = 25;
            while (true) {
                try (Socket socket = new Socket(host, port);
                     BufferedOutputStream output = new BufferedOutputStream(socket.getOutputStream());
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    System.out.println("socket is connected on " + socket.getRemoteSocketAddress().toString());
                    socket.setSoTimeout(50000);
                    try (BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(Path.of(filePath).toString()))) {
                        output.write(buffer.readAllBytes());
                    }
                    socket.shutdownOutput();
                    System.out.println("socket shutdown output");
                    System.out.println("uuid = " + reader.readLine());
                } catch (IOException e) {
                    System.out.println(e.getLocalizedMessage());
                    Thread.sleep(100);
                    x--;
                    if (x < 0) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("exit");
    }
}