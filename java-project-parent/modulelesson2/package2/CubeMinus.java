package package2;


import package3.Cube;

/**
 * Hello world!
 */
public class CubeMinus implements Cube {
    @Override
    public String getName() {
        return "cube_minus";
    }

    @Override
    public int operation(int a, int b) {
        return a - b;
    }

    public static void action(Cube cube) {
        System.out.println(cube.getName());
        cube.action(cube.getAction());
    }
}

abstract class Test {

}

