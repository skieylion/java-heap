package project.java;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        String body = HttpClient.newHttpClient()
                .send(HttpRequest.newBuilder().uri(URI.create("http://google.com")).build(),
                        HttpResponse.BodyHandlers.ofString()).body();
        System.out.println(body);
    }
}
