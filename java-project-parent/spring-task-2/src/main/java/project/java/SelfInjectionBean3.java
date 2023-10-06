package project.java;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SelfInjectionBean3 {
    private final SelfInjectionBean3 self;

    public SelfInjectionBean3(@Lazy SelfInjectionBean3 self) {
        this.self = self;
    }

    public void todo() {
        self.log();
    }

    public void log() {
        System.out.println("self bean 3 : ");
    }
}
