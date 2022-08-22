package project.java;


public class App {
    public static void main(String[] args) {
        //Gen<Integer> ob1 = new Gen<Integer>(88);
        Gen2 ob2 = new Gen2("asd");
        //ob1.getObj();
        ob2.getObj();
    }
}

class Gen<T> {
    T obj;

    Gen(T obj) {
        this.obj = obj;
    }

    T getObj() {
        System.out.println("Gen");
        return obj;
    }
}

class Gen2 extends Gen<String> {

    Gen2(String obj) {
        super(obj);
    }

    String getObj() {
        System.out.println("Gen2");
        return obj;
    }
}