package project.java;

interface MyNumber<T> {
    boolean func(T t1, T t2);
}
class AppDemo {
    static <T> boolean equal(T t1, T t2) {
        return t1 == t2;
    }
}
public class App {
    public static void main(String[] args) {
        System.out.println(compare(AppDemo::<String>equal, "aa", "dd"));
        System.out.println(compare(AppDemo::<Integer>equal, 1, 1));
    }

    static <T> boolean compare(MyNumber<T> myNumber, T t1, T t2) {
        return myNumber.func(t1, t2);
    }
}


