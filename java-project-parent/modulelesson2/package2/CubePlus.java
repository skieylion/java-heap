package package2;


import package3.Cube;

/**
 * Hello world!
 */
public class CubePlus implements Cube {
    @Override
    public String getName() {
        return "cube_plus";
    }
    @Override
    public int operation(int a, int b) {
        return a + b;
    }
}
