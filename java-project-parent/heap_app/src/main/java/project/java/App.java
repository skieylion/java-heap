package project.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    private static final String NEW_LINE = "\r\n";

    public static void main(String[] args) {
        System.out.println(Integer.toString(0b0000_0001,2));

        StringBuilder sequence = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());
            Deque deque = new Deque(m);
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String command = tokenizer.nextToken();
                try {
                    switch (command) {
                        case "push_back":
                            deque.pushBack(Integer.parseInt(tokenizer.nextToken()));
                            break;
                        case "push_front":
                            deque.pushFront(Integer.parseInt(tokenizer.nextToken()));
                            break;
                        case "pop_front":
                            sequence.append(deque.popFront()).append(NEW_LINE);
                            break;
                        case "pop_back":
                            sequence.append(deque.popBack()).append(NEW_LINE);
                            break;
                    }
                } catch (IndexOutOfBoundsException e) {
                    sequence.append("error").append(NEW_LINE);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sequence);
    }
}


class Deque {
    private final int[] elements;
    private final int size;
    private int head, tail;
    private int counter;

    Deque(int size) {
        this.size = size;
        this.elements = new int[size];
        counter = 0;
        head = 0;
        tail = size > 1 ? 1 : 0;
    }

    void pushBack(int value) {
        if (counter + 1 > size)
            throw new IndexOutOfBoundsException();
        elements[tail] = value;
        tail = tail == size - 1 ? 0 : tail + 1;
        counter++;
    }

    void pushFront(int value) {
        if (counter + 1 > size)
            throw new IndexOutOfBoundsException();
        elements[head] = value;
        head = head == 0 ? size - 1 : head - 1;
        counter++;
    }

    int popBack() {
        if (counter == 0)
            throw new IndexOutOfBoundsException();
        counter--;
        tail = tail == 0 ? size - 1 : tail - 1;
        return elements[tail];
    }

    int popFront() {
        if (counter == 0)
            throw new IndexOutOfBoundsException();
        counter--;
        head = head == size - 1 ? 0 : head + 1;
        return elements[head];
    }
}

