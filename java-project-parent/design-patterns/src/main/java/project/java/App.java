package project.java;

import project.java.decorator.text.processor.HtmlEscapeProcessorDecorator;
import project.java.decorator.text.processor.LowerCaseProcessorDecorator;
import project.java.decorator.text.processor.TextProcessor;
import project.java.decorator.text.processor.WhitespaceRemoverDecorator;
import project.java.facade.CaptureFrameFacade;

public class App {
    public static void main(String[] array) {
        String pathFrom = "C:\\work\\opencv\\video.mp4";
        String pathTo = "C:\\work\\opencv\\image";
        CaptureFrameFacade.createImages(5, pathFrom, pathTo, "jpg");
    }
}
