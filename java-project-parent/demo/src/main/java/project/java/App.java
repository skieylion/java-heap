package project.java;


import java.math.BigDecimal;

class A {
    public void print() {
        System.out.println("A");
    }
}

class B extends A {

    public void print() {
        System.out.println("B");
    }
}


public class App {
    public static void main(String[] args) {
        System.out.println("-------------------------------");
        System.out.println(1.245645645e-1);
        float f2=0.1234567845674567456f;
        double xd=40d;
        System.out.println(f2);
        System.out.println(0xAA.21p7);
        System.out.println("-------------------------------");
        float piValue = (float)Math.PI;
        double piValueExt = Math.PI;
        System.out.println("Float value: " + piValue );
        System.out.println("Double value: " + piValueExt );
        System.out.println("float value: " + (2.0f-1.9f) );
        System.out.println("-------------------------------");
        Cat cat = new Cat();
        Float f = 2f;
        System.out.println(cat instanceof Animal);
        System.out.println(cat instanceof Maincoon);
        System.out.println(f instanceof Number);

        System.out.println("-------------------------------");
        int x = 10;
        int y = x++;
        System.out.println(x);
        System.out.println(y);
        System.out.println("++");
        x = 5;
        y = ++x;
        System.out.println(x);
        System.out.println(y);

        System.out.println("-------------------------------");
        boolean b1 = true, b2 = true;
        System.out.println(b1 ^ b2);

        System.out.println("-------------------------------");
        byte byteVar = 0x0021;
        short shortVar = 129;
        int intVar = 0xFFFF + 0x0021 + 0x1;
        char charVar = '\u0021';


        System.out.println((byte) shortVar);
        System.out.println((char) intVar);
        System.out.println(~0x10);
        int p1=0;
        int p2=0;
        System.out.println((p2++)*10+(++p1));
        System.out.println(p2);
        System.out.println("--------------------------");
        System.out.println(~0x01 << 1);
        System.out.println(0x01 << 2);
        System.out.println("<<------------------------");
        System.out.println(Integer.toBinaryString(0b0000_0011 << 1));
        System.out.println(Integer.toBinaryString(0b0000_0011 << 20));
        System.out.println(">>------------------------");
        System.out.println(Integer.toBinaryString(0b1000_0011 >> 1));
        System.out.println(Integer.toBinaryString(0b1000_0011 >> 20));
        System.out.println(">>------------------------");
        System.out.println(0b01_1111111_11111111_11111111_1111110);

        float f1 = 5.0f;
        System.out.println("asd" + f1 / 0.0f);
        //1_000_0000_0000_0000_0000_0000_0000_0000
        //byte,short,int,long
        //new Test3();

        A var = new B();


    }
}
