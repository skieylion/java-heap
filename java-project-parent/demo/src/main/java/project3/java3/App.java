package project3.java3;


import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Math.*;
import static java.lang.System.out;


class A {
    public void print() {
        System.out.println("A");
    }

    public static void test() {
        System.out.println("static A.test");
    }
}

class B extends A {

    public void print() {
        System.out.println("B" + PI);
        double y = pow(1d, 2d);
    }
}

enum TestEnum {
    WINTER(1, "winter") {
        public String getName() {
            return "winterName";
        }

        public String getTest() {
            return "test";
        }

        @Override
        public void parse() {

        }
    },
    SUMMER(2, "summer") {
        @Override
        public void parse() {

        }
    },
    SPRING(3, "spring") {
        @Override
        public void parse() {

        }
    },
    AUTUMN(4, "autumn") {
        @Override
        public void parse() {

        }
    };

    public abstract void parse();

    private int num;
    private String name;

    TestEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static void foo() {
        System.out.println("static foo");
    }


}

class YY<T> {

}


class D {
    public String name;
}

class C {
    public static void Test(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    public void tw(D d) {
        //d = new D();
        d.name = "fromC";
    }
}


class K {
    public static int v1 = 4;

    public static int v2 = f2();

    static {
        System.out.println("Статический блок");
    }

    {
        System.out.println("Блок");
    }

    K() {
        System.out.println("Конструктор");
    }

    K(int x) {
        this();
        System.out.println("Конструктор с аргументом");
    }

    private static int f2() {
        System.out.println("Статическая функция");
        return 10;
    }


}

class C1 {
    public int x = 1;

    C1(int z) {
        out.println("C1");
    }
}

class C2 extends C1 {
    C2(int z) {
        super(1);
        out.println("C2");
    }
}

class C3 {
    //    void f(float x) {
//        out.println("float");
//    }
//
//    void f(double x) {
//        out.println("double");
//    }
    void f(byte x) {
        out.println("byte");
    }
//    void f(int x) {
//        out.println("int");
//    }

//    void f(long x) {
//        out.println("long");
//    }
}

class C4 extends C3 {
    void f(byte x) {

    }
}

class C5 {
//    public void notify() {
//
//    }
}

class C6 {

    C6() {
        out.println("C6 ::");
    }

    public C6(String s) {
        out.println("C6 ::");
    }

    public static boolean test(Predicate<Integer> p, Integer v) {
        return p.test(v);
    }

    public static <T> void test2(Consumer<T> action, T v) {
        action.accept(v);
    }

    public static <T> void test3(Runnable runnable) {
        runnable.run();
    }


}


public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    static {
        logger.setLevel(Level.FINER);
        logger.getParent().setLevel(Level.FINER);
    }

    public static void main(String[] args) {
        Arrays.stream(new String[]{"1","sad"}).map(C6::new).forEach(out::println);
        Arrays.stream(new String[]{"1","sad"}).toArray(C6[]::new);
        //C6.test3(C6::new);
//        C6.test2(out::println, "sad");
//
//        //log.setLevel(Level.ALL);
//        Arrays.sort(new String[]{"a", "s", "f"}, String::compareToIgnoreCase);
//        logger.info(String.valueOf(C6.test((e) -> true, 1)));
//        Arrays.stream(new String[]{"a", "sd"}).forEach(out::println);
//        logger.finest("asdasdasd123123");
        //log.info("INFO");
        //log.fine("FINE");
        //Arrays.stream(new String[]{"a","sd"}).map(String[]::new).forEach();

        //log.log(Level.INFO,"FINE");
        //log.logp(Level.INFO,"ASD","asd","asd");
        //logger.info(logger.getLevel().getName());
        logger.setLevel(Level.FINER);
        logger.setLevel(Level.FINER);
        logger.throwing(App.class.getName(), App.class.getMethods()[0].getName(), new ArithmeticException());

        // YY<TestEnum> x=new YY<>();


//        C3 c31 = new C3();
//        C3 c3 = new C4();
//        C4 c4 = new C4();
//
//        if (c31 instanceof C4) {
//            C4 c4new = (C4) c31;
//        }


//        ArrayList<Integer> list=new ArrayList<>();
//
//        out.println(c3.getClass().getName());
//
//        Object obj;
//        Integer i1=128;
//        Integer i2=128;
//        Byte b1=100;
//        Byte b2=100;
//        out.println(i1==i2);
//        out.println(b1==b2);
//        C3 c3=new C3();
//        long a=5;
//        float b=2.0f;
//        byte t=0xA;
//        c3.f((byte)0xA);

        //C2 c2=new C2(1);

//ArrayStoreException
//        C2[] arrC2=new C2[10];
//        C1[] arrC1=arrC2;
//        arrC1[0]=new C1(2);

//        K k=new K(1);
//        out.println();
//        D d = new D();
//        d.name = "fromApp";
//        C c = new C();
//        c.tw(d);
//        System.out.println(d.name);
//        K k=new K();
//        System.out.println("");
//        System.out.printf("%d \t %d",k.v1,k.v2);
//        K k2=new K();
//        System.out.println("");
//        System.out.printf("%d",k2.v2);
        //даты
//        Date date = new Date();
//        LocalDate localDate = LocalDate.now();
//        System.out.printf("%th", localDate);

//        //одномерные массивы
//        int[] arr1=new int[2];
//        int arr2[]=new int[3];
//        int[] arr3=new int[]{1,2,3};
//        int[] arr4=new int[0];
//        int[] arr5=new int[]{};
//        int[] arr6=Arrays.copyOf(arr3,1);
//        Integer[] arr7=(Integer[]) Arrays.stream(arr3).boxed().toArray(Integer[]::new);
//        Arrays.sort(arr7,(var a,var b)->b-a);
//        Arrays.stream(arr7).forEach(System.out::println);
//
//        //многомерные массивы
//        double[][] tab1=new double[3][3];
//        double tab2[][];
//        double[][] tab3;
//        double[][] tab4=new double[][]{
//                {1,2,1,2,2},
//                {2,3,34,4,5}
//        };

        //Arrays.stream(arr3).forEach();

//        System.out.printf("%.2f\t%a\t%s\t\t%h", 2.912, 0xAA.1p1, "asd", "asd");
//        System.out.println("");
//        System.out.printf("%1$tT", new Date());
//        System.out.println("");
//        System.out.println("start");
//        //test:
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (i > 2 | j > 2) {
//                    break;
//                } else {
//                    System.out.printf("[%d,%d]\t", i, j);
//                }
//            }
//            System.out.println("");
//            //break test;
//        }
//        System.out.println("\nend");


        //Scanner scanner=new Scanner(System.in);
        //String str=scanner.nextLine();


//        Console console=System.console();
//        char[] password=console.readPassword();
//        System.out.println(password);
//        TestEnum testEnum = TestEnum.WINTER;
//        TestEnum.foo();
//        TestEnum[] list = TestEnum.values();
//        System.out.println(TestEnum.valueOf("SUMMER").getName());
//        System.out.println();
//        testEnum.parse();
//        char c='\u0000';
//        System.out.println((double) (3.14159f));
//        String x="ad";
//        Character ch='\u1010';
//        String str=null;
//        System.out.println(str.isEmpty());
//        Object s=new Object();

        // castle noun
        // definition - it is ...
        // examples
        // String substr="[]".repeat("castle".length());
        // String result = example.replace("castle",substr);


        //TestEnum testEnum = TestEnum.AUTUMN;
        //System.out.println(testEnum instanceof TestEnum);
//        int num=0;
//        for(int i=0;i<100;i++)
//            num=num++;
//
//        System.out.println(num);
//
//        int x=1;
//        int y=(x++)+(x*2);
//
//        System.out.println(y);
//        System.out.println(x);
//
//        int a=2;
//        int b=(a++)+(a++);//1+1=2
//        System.out.println(b);
//        System.out.println(a);

        //A.test();
        //A obj = null;
        //obj.test();

//        System.out.println("-------------------------------");
//        System.out.println(1.245645645e-1);
//        float f2=0.1234567845674567456f;
//        double xd=40d;
//        System.out.println(f2);
//        System.out.println(0xAA.21p7);
//        System.out.println("-------------------------------");
//        float piValue = (float)Math.PI;
//        double piValueExt = Math.PI;
//        System.out.println("Float value: " + piValue );
//        System.out.println("Double value: " + piValueExt );
//        System.out.println("float value: " + (2.0f-1.9f) );
//        System.out.println("-------------------------------");
//        Cat cat = new Cat();
//        Float f = 2f;
//        System.out.println(cat instanceof Animal);
//        System.out.println(cat instanceof Maincoon);
//        System.out.println(f instanceof Number);
//
//        System.out.println("-------------------------------");
//        int x = 10;
//        int y = x++;
//        System.out.println(x);
//        System.out.println(y);
//        System.out.println("++");
//        x = 5;
//        y = ++x;
//        System.out.println(x);
//        System.out.println(y);
//
//        System.out.println("-------------------------------");
//        boolean b1 = true, b2 = true;
//        System.out.println(b1 ^ b2);
//
//        System.out.println("-------------------------------");
//        byte byteVar = 0x0021;
//        short shortVar = 129;
//        int intVar = 0xFFFF + 0x0021 + 0x1;
//        char charVar = '\u0021';
//
//
//        System.out.println((byte) shortVar);
//        System.out.println((char) intVar);
//        System.out.println(~0x10);
//        int p1=0;
//        int p2=0;
//        System.out.println((p2++)*10+(++p1));
//        System.out.println(p2);
//        System.out.println("--------------------------");
//        System.out.println(~0x01 << 1);
//        System.out.println(0x01 << 2);
//        System.out.println("<<------------------------");
//        System.out.println(Integer.toBinaryString(0b0000_0011 << 1));
//        System.out.println(Integer.toBinaryString(0b0000_0011 << 20));
//        System.out.println(">>------------------------");
//        System.out.println(Integer.toBinaryString(0b1000_0011 >> 1));
//        System.out.println(Integer.toBinaryString(0b1000_0011 >> 20));
//        System.out.println(">>------------------------");
//        System.out.println(0b01_1111111_11111111_11111111_1111110);
//
//        float f1 = 5.0f;
//        System.out.println("asd" + f1 / 0.0f);
//        //1_000_0000_0000_0000_0000_0000_0000_0000
//        //byte,short,int,long
//        //new Test3();
//
//        A var = new B();


    }
}
