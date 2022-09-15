package package1;

//import package3.Cube;
//import package3.CubeProvider;

import package4.CubeOther;

import java.util.ServiceLoader;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CubeOther cubeOther = new CubeOther();
    }
}

//        for (CubeProvider cb : ServiceLoader.load(CubeProvider.class)) {
//            Cube cube = cb.get();
//            String name = cube.getName();
//            int result = cube.operation(4, 6);
//            System.out.println(name + " = " + result);
//        }