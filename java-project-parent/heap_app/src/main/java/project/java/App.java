package project.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {

    private static final String SPACE = " ";
    private static final String ZERO = "0";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            StringBuilder builder = new StringBuilder(15_000_000);
            int[] plots = new int[n];
            int counter = -1;
            int lastZeroIndex = 0;
            for (int i = 0; i < n; i++) {
                if (ZERO.equals(tokenizer.nextToken())) {
                    counter = 1;
                    lastZeroIndex = i;
                    continue;
                }
                if (counter != -1) {
                    plots[i] = counter++;
                    continue;
                }
                plots[i] = n;
            }
            counter = -1;
            for (int i = n - 1; i > -1; i--) {
                if (plots[i] == 0) {
                    counter = 1;
                } else if (counter != -1) {
                    if (counter < plots[i]) {
                        plots[i] = counter++;
                    } else {
                        counter = -1;
                    }
                }
                builder.insert(0, SPACE).insert(0, plots[i]);
            }
            System.out.print(builder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}