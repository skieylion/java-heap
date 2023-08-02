package project.java.decorator.text.processor;

public class WhitespaceRemoverDecorator extends TextProcessor {
    public WhitespaceRemoverDecorator(Processable process) {
        super(process);
    }

    @Override
    public String process(String text) {
        return super.process(text).trim();
    }
}
