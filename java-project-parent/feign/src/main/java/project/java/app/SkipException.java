package project.java.app;

public class SkipException extends Exception {
    public SkipException() {
        super("Вызов не может быть обработан по данной заявке");
    }
}
