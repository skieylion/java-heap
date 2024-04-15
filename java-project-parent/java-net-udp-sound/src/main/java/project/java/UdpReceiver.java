package project.java;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import javax.sound.sampled.*;

public class UdpReceiver {
    static AudioFormat getAudioFormat() {
        float sampleRate = 44100.0F;
        int sampleSizeInBits = 16;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = false;
        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
    }

    @SneakyThrows
    public static void main(String[] args) {
        byte[] buffer = new byte[4096];
        AudioFormat format = getAudioFormat();
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

        if (!AudioSystem.isLineSupported(info)) {
            System.out.println("Line not supported");
            System.exit(0);
        }
        SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
        line.open(format);
        line.start();


        try (DatagramSocket datagramSocket = new DatagramSocket(7777)) {
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            while (true) {
                datagramSocket.receive(datagramPacket);
                line.write(datagramPacket.getData(), 0, datagramPacket.getLength());
            }


        }
    }
}
