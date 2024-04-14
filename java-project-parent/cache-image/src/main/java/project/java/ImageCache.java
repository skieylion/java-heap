package project.java;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.WeakHashMap;

public class ImageCache {
    private static final WeakHashMap<String, BufferedImage> CACHE;

    static {
        CACHE = new WeakHashMap<>();
    }

    public static BufferedImage loadImage(String imagePath) {
        if (!Objects.nonNull(CACHE.get(imagePath))) {
            try (InputStream is = ImageCache.class.getResourceAsStream(imagePath)) {
                if (Objects.nonNull(is)) {
                    BufferedImage image = ImageIO.read(is);
                    CACHE.put(imagePath, image);
                    return image;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return CACHE.get(imagePath);
    }

    public static void clear() {
        CACHE.keySet().forEach(key -> CACHE.put(key, null));
    }

    public static WeakReference<BufferedImage> getWeakReferenceBufferedImageByPath(String imagePath) {
        return new WeakReference<>(CACHE.get(imagePath));
    }

}
