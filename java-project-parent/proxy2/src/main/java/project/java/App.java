package project.java;

import java.util.Random;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Clickable clicker = new RandomClickerProxy();

        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            if (r.nextInt(100) < 5) {
                clicker.click();
            }
        }
    }
}
