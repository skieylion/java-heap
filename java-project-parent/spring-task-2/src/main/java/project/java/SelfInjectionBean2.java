package project.java;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SelfInjectionBean2 {
    @Lookup
    public SelfInjectionBean1 self() {
        return null;
    }

    ;

    public void log() {
        System.out.println("self bean 2 : " + self());
    }
}
