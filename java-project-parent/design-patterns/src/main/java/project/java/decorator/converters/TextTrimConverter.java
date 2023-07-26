package project.java.decorator.converters;

public class TextTrimConverter implements Convertible {
    @Override
    public String convert(String text) {
        return text.trim();
    }
}
