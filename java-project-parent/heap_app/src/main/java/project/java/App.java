package project.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {

    private static final String NEW_LINE = "\r\n";

    public static void main(String[] args) {
        StringBuilder sequence = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());
            Deque deque = new Deque((char) m);
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String command = tokenizer.nextToken();
                try {
                    switch (command) {
                        case "push_back":
                            deque.addLast(Short.parseShort(tokenizer.nextToken()));
                            break;
                        case "push_front":
                            deque.addFirst(Short.parseShort(tokenizer.nextToken()));
                            break;
                        case "pop_front":
                            sequence.append(deque.pollFirst()).append(NEW_LINE);
                            break;
                        case "pop_back":
                            sequence.append(deque.pollLast()).append(NEW_LINE);
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

    private char head, tail;
    private short[] elements;
    private char counter;
    private char size;

    public Deque(char size) {
        head = 0;
        tail = (char) (size > 1 ? 1 : 0);
        elements = new short[Character.MAX_VALUE + 1];
        counter = 0;
        this.size = size;
    }

    void addLast(short e) {
        if (counter + 1 < size) {
            elements[tail++] = e;
            counter++;
        } else throw new IndexOutOfBoundsException();
    }

    void addFirst(short e) {
        if (counter + 1 < size) {
            elements[head--] = e;
            counter++;
        } else throw new IndexOutOfBoundsException();
    }

    short pollLast() {
        if (counter > 0) {
            counter--;
            return elements[--tail];
        }
        throw new IndexOutOfBoundsException();
    }

    short pollFirst() {
        if (counter > 0) {
            counter--;
            return elements[++head];
        }
        throw new IndexOutOfBoundsException();
    }


}