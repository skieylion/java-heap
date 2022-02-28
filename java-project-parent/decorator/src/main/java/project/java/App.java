package project.java;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Developer developer= new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloper()));
        System.out.println(developer.makeJob());
    }
}
