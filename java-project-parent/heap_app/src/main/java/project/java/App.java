package project.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 2 * Integer.parseInt(scanner.nextLine());
        Map<Integer, Integer> buttonMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            var array = scanner.nextLine().split("");
            for (var token : array) {
                if (!".".equals(token)) {
                    var key = Integer.valueOf(token);
                    buttonMap.compute(key, (k, v) -> Objects.nonNull(v) ? v + 1 : 1);
                }
            }
        }
        long count = buttonMap.values().stream()
                .filter(v -> v <= n)
                .mapToInt(Integer::intValue).count();
        System.out.println(count);
    }
}