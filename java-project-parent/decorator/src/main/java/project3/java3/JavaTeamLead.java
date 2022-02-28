package project3.java3;

public class JavaTeamLead extends DecoratorDeveloper {
    public JavaTeamLead(Developer developer) {
        super(developer);
    }

    @Override
    public String makeJob() {
        return super.makeJob()+" Send week report to a customer";
    }
}
