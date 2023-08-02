package project.java.decorator.text.processor;

import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlEscapeProcessorDecorator extends TextProcessor {
    public HtmlEscapeProcessorDecorator(Processable process) {
        super(process);
    }

    @Override
    public String process(String text) {
        return StringEscapeUtils.escapeHtml4(super.process(text));
    }
}
