package project.java.decorator.text.processor;

public abstract class TextProcessor implements Processable {

    private final Processable processable;

    public TextProcessor(Processable process) {
        this.processable = process;
    }

    @Override
    public String process(String text) {
        return processable.process(text);
    }
}
