package project.java.feigns;

import feign.RetryableException;
import feign.Retryer;

public class CustomRetryer implements Retryer {

    private static final int MAX_ATTEMPTS = 3;
    private static final long BACKOFF_PERIOD = 1000; // В миллисекундах

    private int attempts = 1;

    @Override
    public void continueOrPropagate(RetryableException e) {
        System.out.println("continueOrPropagate");
        if (attempts++ > MAX_ATTEMPTS) {
            throw e; // Бросаем RetryableException, если превышено максимальное количество попыток
        }
        try {
            Thread.sleep(BACKOFF_PERIOD); // Ожидание перед повторным выполнением запроса
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Retryer clone() {
        return new CustomRetryer();
    }
}
