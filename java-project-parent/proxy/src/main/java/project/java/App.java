package project.java;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("---------------1----------------------");
        Project project1=new RealProject("http://google.com");
        System.out.println("---");
        project1.run();
        System.out.println("---------------2----------------------");
        Project project2=new ProxyProject("http://google.com");
        System.out.println("---");
        project2.run();
    }
}
