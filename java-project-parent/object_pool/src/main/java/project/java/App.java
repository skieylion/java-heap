package project.java;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static void log(String str) {
        System.out.println(LocalDateTime.now() + " : " + str);
    }

    public static void main(String[] args) {
        log("getting an object ...");
        ColorPool colorPool=new ColorPool(4);
        Color color = colorPool.getColor();
        for (int i = 0; i < 20; i++) {
            final double rnd = Math.random();
            if (rnd > 0.5) {
                log("releasing an object");
                colorPool.release(color);
            } else {
                log("getting an object ...");
                color = colorPool.getColor();
            }
        }
        log("stop");
    }
}

class Color {
    String name;

    public Color() {
        try {
            Thread.sleep(2000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

class ColorPool {
    private final List<Color> colorList = new ArrayList<>();

    public ColorPool(int minCount) {
        for(int i=0;i<minCount;i++){
            colorList.add(new Color());
        }
    }

    public Color getColor() {
        if (colorList.isEmpty()) {
            return new Color();
        } else {
            final int index = colorList.size() - 1;
            Color color = colorList.get(index);
            colorList.remove(index);
            return color;
        }
    }

    public void release(Color color) {
        if (!colorList.contains(color)) {
            colorList.add(color);
        }
    }
}