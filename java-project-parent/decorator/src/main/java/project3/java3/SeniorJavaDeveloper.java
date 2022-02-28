package project3.java3;

public class SeniorJavaDeveloper extends DecoratorDeveloper {
    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }

    @Override
    public String makeJob() {
        return super.makeJob()+"Make code review. ";
    }
}
