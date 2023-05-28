package package3;

import package31.Runtime;

public interface Cube {
    String getName();

    int operation(int a, int b);

    default void action(Runtime runtime) {
        System.out.println(runtime);
    }

    default Runtime getAction() {
        return new Runtime();
    }
}
