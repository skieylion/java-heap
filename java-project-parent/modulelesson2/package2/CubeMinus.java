package package2;


import package3.Cube;
import package4.CubeOther;

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
        CubeOther cubeOther = new CubeOther();
        cubeOther.print();
        return a - b;
    }
}
