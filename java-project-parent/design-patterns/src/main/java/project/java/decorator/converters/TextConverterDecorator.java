package project.java.decorator.converters;

public abstract class TextConverterDecorator implements Convertible {

    private final Convertible convertible;

    public TextConverterDecorator(Convertible convertible) {
        this.convertible = convertible;
    }

    @Override
    public String convert(String text) {
        return convertible.convert(text);
    }
}
