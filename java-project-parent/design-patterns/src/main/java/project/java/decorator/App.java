package project.java.decorator;

import project.java.decorator.text.processor.HtmlEscapeProcessorDecorator;
import project.java.decorator.text.processor.LowerCaseProcessorDecorator;
import project.java.decorator.text.processor.TextProcessor;
import project.java.decorator.text.processor.WhitespaceRemoverDecorator;

public class App {
    public static void main(String[] array) {
        var dec1 = new LowerCaseProcessorDecorator();
        var dec2 = new WhitespaceRemoverDecorator(dec1);
        var dec3 = new HtmlEscapeProcessorDecorator(dec2);
        System.out.println(dec3.process("      <html>Hello</html>    "));
    }
}
