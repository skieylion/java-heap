package project.java;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ToolkitFactoryFactory.createFactory("MetalFactory").createSaw().workSaw();
        ToolkitFactoryFactory.createFactory("MetalFactory").createDrill().workDrill();

        ToolkitFactory toolkitFactory = new MetalToolkitFactory();
        Saw saw = toolkitFactory.createSaw();
        Drill drill = toolkitFactory.createDrill();
        saw.workSaw();
        drill.workDrill();

        System.out.println("Hello World!");
    }
}
