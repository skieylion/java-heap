package package1;

import package3.Cube;
import package31.*;
import package2.CubeMinus;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Cube cube = new CubeMinus();
        CubeMinus.action(cube);
    }
}

//        for (CubeProvider cb : ServiceLoader.load(CubeProvider.class)) {
//            Cube cube = cb.get();
//            String name = cube.getName();
//            int result = cube.operation(4, 6);
//            System.out.println(name + " = " + result);
//        }