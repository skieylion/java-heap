package project.java;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sequence = new StringBuilder(scanner.nextLine());
        int i = 0, j = sequence.length() - 1;
        while (sequence.length() > 0 && j >= 0) {
            char symbol = sequence.charAt(j);
            if (isLeftSymbol(symbol)) {
                if (j + 1 < sequence.length()
                        && symbol == reverse(sequence.charAt(j + 1))) {
                    sequence.delete(j, j + 2);
                } else {
                    System.out.print("False");
                    return;
                }
            }
            j--;
        }
        if (sequence.length() > 0) {
            System.out.print("False");
        } else {
            System.out.println("True");
        }
    }

    static boolean isLeftSymbol(char symbol) {
        return symbol == '{' || symbol == '[' || symbol == '(';
    }

    static char reverse(char symbol) {
        switch (symbol) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
        }
        throw new IllegalArgumentException("The symbol " + symbol + " is not valid");
    }


}
