package project.java;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public abstract class SelfInjectionBean1 {

    @Lookup
    public abstract SelfInjectionBean1 self();

    public void log() {
        System.out.println("self bean 1 : "+self());
    }
}