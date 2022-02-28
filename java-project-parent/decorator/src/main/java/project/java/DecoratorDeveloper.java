package project.java;

public class DecoratorDeveloper implements Developer{

    private final Developer developer;

    public DecoratorDeveloper(Developer developer) {
        this.developer = developer;
    }

    @Override
    public String makeJob() {
        return developer.makeJob();
    }
}
