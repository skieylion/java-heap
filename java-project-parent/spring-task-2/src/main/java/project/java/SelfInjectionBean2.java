package project.java;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("prototype")
public class SelfInjectionBean2 {

    @Resource(name = "selfInjectionBean3")
    private SelfInjectionBean3 selfInjectionBean3;

    @Lookup
    public SelfInjectionBean2 self() {
        return null;
    }


    public void log() {
        System.out.println("self bean 2 : " + self());
        selfInjectionBean3.log();
    }
}
