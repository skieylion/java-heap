package project.java;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSocketSender {
    @SneakyThrows
    public static void main(String[] args) {
        var address = InetAddress.getLocalHost();
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            var bytes = "Hello from client".getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, 7777);
            datagramSocket.send(datagramPacket);
        }
    }
}
