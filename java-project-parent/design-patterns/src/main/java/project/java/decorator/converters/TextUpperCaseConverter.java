package project.java.decorator.converters;

public class TextUpperCaseConverter extends TextConverterDecorator {
    public TextUpperCaseConverter(Convertible convertible) {
        super(convertible);
    }

    @Override
    public String convert(String text) {
        String[] words = super.convert(text).toLowerCase().split(" ");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            String firstLetter = word.substring(0, 1);
            String otherLetters = word.substring(1);
            builder.append(firstLetter.toUpperCase()).append(otherLetters).append(" ");
        }
        return builder.toString();
    }
}
