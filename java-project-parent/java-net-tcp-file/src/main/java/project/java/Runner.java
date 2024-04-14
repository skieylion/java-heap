package project.java;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Runner {
    public static void main(String[] args) throws IOException {
        if ("server".equals(args[0])) {
            ServerRunner.run(Integer.parseInt(args[1]));
        } else if ("client".equals(args[0])) {
            SocketRunner.run(args[1], Integer.parseInt(args[2]), args[3]);
        } else {
            throw new IllegalArgumentException("the program couldn't recognize server or client mode");
        }
    }
}
