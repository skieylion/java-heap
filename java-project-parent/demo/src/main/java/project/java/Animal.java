package project.java;

public class Animal {
    Animal() {
        TestProtected testProtected=new TestProtected();
        testProtected.data=";asd;";
        System.out.println(testProtected.data);
    }
}
