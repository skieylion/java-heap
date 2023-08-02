package project.java.decorator.text.processor;

public class LowerCaseProcessorDecorator implements Processable {
    @Override
    public String process(String text) {
        return text.toLowerCase();
    }
}