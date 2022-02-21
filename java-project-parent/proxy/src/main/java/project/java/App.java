package project.java;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Test {
        //IllegalAccessException exception;
        throw new Test("asd");
        //System.out.println( "Hello World!" );
//        try {
//            NullPointerException e = new NullPointerException("up level");
//            e.initCause(new ArithmeticException("a reason"));
//            throw e;
//        } catch (NullPointerException e) {
//            System.out.println("the exception is "+e);
//            System.out.println("the reason is "+e.getCause());
//        }
    }
}
