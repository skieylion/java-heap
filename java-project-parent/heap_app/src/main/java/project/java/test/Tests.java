package project.java.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tests {
    private Tests() {

    }

    public static void test() {
        log.info("!!!!INFO");
        log.warn("!!!!WARN");
        log.debug("!!!!DEBUG");
        log.error("!!!!ERROR");
    }
}
