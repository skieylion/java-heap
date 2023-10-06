package project.java;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
public abstract class SelfInjectionBean1 {
    @Value("${app.sentence}")
    private String sentence;

    @Value("${app.sentence.default:Hi World}")
    private String defaultSentence;

    @Value("${app.names}")
    private String[] names;

    @Value("${app.names}")
    private List<String> listOfNames;

    @Value("#{${app.coords}}")
    private Map<String, Integer> coords;

    @Lookup
    public abstract SelfInjectionBean1 self();

    public void log() {
        System.out.println("self bean 1 : " + self());
        System.out.println("sentence : " + sentence);
        System.out.println("defaultSentence : " + defaultSentence);
        System.out.println("names : " + Arrays.toString(names));
        System.out.println("coords : " + coords);
        System.out.println("list of names : " + listOfNames);
    }
}