package project3.java3;

public class Test extends Exception {
    public Test(String str) {
        super(str);
        this.initCause(new ArithmeticException("a reason"));
    }

//    @Override
//    public String toString(){
//        return "";
//    }
}
