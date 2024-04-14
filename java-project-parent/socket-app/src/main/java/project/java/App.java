package project.java;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        final String serverAddress = "localhost"; // Адрес сервера
        final int serverPort = 8989; // Порт сервера

        for (int i = 0; i < 100000; i++) {

            try (Socket socket = new Socket(serverAddress, serverPort)) {
                System.out.println("Подключено к серверу на " + serverAddress + ":" + serverPort);

                // Получаем поток вывода для отправки данных на сервер
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);

                // Отправляем сообщение на сервер
                String message = "Привет, сервер!";
                writer.println(message);
                System.out.println("Отправлено сообщение: " + message);
            } catch (Exception e) {
                System.err.println("Ошибка при подключении или отправке сообщения: " + e.getMessage());
            }
        }
    }
}
