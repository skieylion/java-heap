package project.java;

import java.util.Random;

public final class RandomUtil {
    private final static Random DEFAULT_RANDOM = new Random();

    private RandomUtil() {
    }

    public static int generateRandomNumber(int bound) {
        return DEFAULT_RANDOM.nextInt(bound);
    }
}
