package project.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        final int port = 8989; // Порт, на котором будет работать сервер
        ExecutorService executor = Executors.newFixedThreadPool(15);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер ожидает подключения на порту " + port);
            serverSocket.setReuseAddress(true);
            while (true) {
                serverSocket.setReuseAddress(true);
                Socket clientSocket = serverSocket.accept();
                executor.execute(() -> {
                    try {
                        task(clientSocket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (IOException e) {
            System.err.println("Ошибка при создании серверного соксета: " + e.getMessage());
        }
        executor.shutdown();
    }

    static void task(Socket clientSocket) throws IOException {
        System.out.println("Подключился клиент: " + clientSocket.getInetAddress());
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Сообщение от клиента: " + line);
        }
        clientSocket.close();
    }

}
