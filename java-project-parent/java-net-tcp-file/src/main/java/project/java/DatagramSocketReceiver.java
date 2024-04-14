package project.java;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class DatagramSocketReceiver {
    @SneakyThrows
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket(7777)) {
            var buffer = new byte[512];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(datagramPacket);
            System.out.println(new String(buffer, StandardCharsets.UTF_8));
        }
    }
}
