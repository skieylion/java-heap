package package2;

import package3.Cube;
import package3.CubeProvider;

public class CubeMinusProvider implements CubeProvider {
    @Override
    public Cube get() {
        return new CubeMinus();
    }
}
